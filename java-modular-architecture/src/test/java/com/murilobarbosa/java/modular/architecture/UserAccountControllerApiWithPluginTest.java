package com.murilobarbosa.java.modular.architecture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.murilobarbosa.java.modular.architecture.application.dto.response.UserAccountResponseDto;
import com.murilobarbosa.java.modular.architecture.fixture.UserAccountFixture;
import com.murilobarbosa.java.modular.architecture.plugin.EnableInsertSql;
import com.murilobarbosa.java.modular.architecture.plugin.InsertSql;
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
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
      properties = {"spring.flyway.enabled=false"})
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@EnableInsertSql
class UserAccountControllerApiWithPluginTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private static final String PATH = "http://localhost:%d/v1/user-account";

    @DisplayName("1. Create user account")
    @Nested
    class CreateUserAccount {

        @Test
@InsertSql(value = "datasets/input/user-accounts-input.json")
        @DisplayName("1.1 Should create a new user account")
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
        @DisplayName("1.2 Should create a new user account")
        void shouldCreateNewUserAccount2() {
            var response = testRestTemplate
                  .exchange(getPath(null),
                        HttpMethod.POST,
                        new HttpEntity<>(UserAccountFixture.newUser()),
                        new ParameterizedTypeReference<UserAccountResponseDto>() {
                        });

            assertNotNull(response.getBody());
            assertEquals(HttpStatus.CREATED, response.getStatusCode());
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