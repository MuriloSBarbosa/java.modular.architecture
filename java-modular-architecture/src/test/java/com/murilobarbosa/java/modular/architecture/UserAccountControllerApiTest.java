package com.murilobarbosa.java.modular.architecture;

import static org.junit.jupiter.api.Assertions.*;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.junit5.api.DBRider;
import com.murilobarbosa.java.modular.architecture.application.dto.response.UserAccountResponseDto;
import com.murilobarbosa.java.modular.architecture.core.dto.base.SearchResultDto;
import com.murilobarbosa.java.modular.architecture.fixture.UserAccountFixture;
import com.murilobarbosa.java.modular.architecture.utils.RegexUUIDReplacer;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
      properties = {"spring.flyway.enabled=false"})
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@DBRider
@DBUnit(cacheConnection = false, alwaysCleanAfter = true, raiseExceptionOnCleanUp = true,
      replacers = RegexUUIDReplacer.class)
class UserAccountControllerApiTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private static final String PATH = "http://localhost:%d/v1/user-account";

    @DisplayName("1. Create user account")
    @Nested
    class CreateUserAccount {

        @Test
        @DisplayName("1.1 Should create a new user account")
        @ExpectedDataSet("datasets/expected/user-account-created-expected.json")
        void shouldCreateNewUserAccount() {
            var response = testRestTemplate
                  .exchange(getPath(null),
                        HttpMethod.POST,
                        new HttpEntity<>(UserAccountFixture.newUser()),
                        new ParameterizedTypeReference<UserAccountResponseDto>() {
                        });

            assertNotNull(response.getBody());
            assertEquals(HttpStatus.CREATED, response.getStatusCode());
        }

        @Test
        @DisplayName("1.2 Shouldn't create conflicted user account")
        @DataSet("datasets/input/user-accounts-input.json")
        @ExpectedDataSet(value = "datasets/input/user-accounts-input.json", orderBy = "id")
        void shouldntCreateConflictedUserAccount() {
            var response = testRestTemplate
                  .exchange(getPath(null),
                        HttpMethod.POST,
                        new HttpEntity<>(UserAccountFixture.newUser()),
                        new ParameterizedTypeReference<UserAccountResponseDto>() {
                        });

            assertEquals(response.getBody(), new UserAccountResponseDto());
            assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        }
    }

    @Nested
    @DisplayName("2. Search user account")
    class SearchUserAccount {

        @Test
        @DisplayName("2.1 Should return only searched user account")
        @DataSet(value = "datasets/input/user-accounts-input.json")
        void shouldReturnOnlySearchedUserAccount() {

            var response = testRestTemplate
                  .exchange(getPath("?email=murilo.barbosa"),
                        HttpMethod.GET,
                        new HttpEntity<>(new HttpHeaders()),
                        new ParameterizedTypeReference<SearchResultDto<UserAccountResponseDto>>() {
                        });

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertNotNull(response.getBody());
            assertEquals(1, response.getBody().getTotalElements());
        }
    }


    @NotNull
    private String getPath(String addition) {
        if (addition == null) {
            return String.format(PATH, port);
        }
        return String.format(PATH + addition, port);
    }

}