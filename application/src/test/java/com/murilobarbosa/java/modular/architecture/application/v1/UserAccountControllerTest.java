package com.murilobarbosa.java.modular.architecture.application.v1;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.murilobarbosa.java.modular.architecture.application.config.TestConfigCustomized;
import com.murilobarbosa.java.modular.architecture.application.controller.v1.UserAccountController;
import com.murilobarbosa.java.modular.architecture.application.fixture.UserAccountFixture;
import com.murilobarbosa.java.modular.architecture.application.utils.AssertJsonUtils;
import com.murilobarbosa.java.modular.architecture.application.utils.FileReaderUtils;
import com.murilobarbosa.java.modular.architecture.application.utils.ObjectMapperUtils;
import com.murilobarbosa.java.modular.architecture.application.controller.v1.impl.UserAccountControllerImpl;
import com.murilobarbosa.java.modular.architecture.application.dto.response.UserAccountResponseDto;
import com.murilobarbosa.java.modular.architecture.core.service.UserAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserAccountController.class)
@Import({UserAccountControllerImpl.class})
@ContextConfiguration(classes = TestConfigCustomized.class)
class UserAccountControllerTest {

    private static final String PATH = "/v1/user-account";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserAccountService service;


    @Nested
    @DisplayName("1. Create User Account")
    class CreateUserAccount {

        @Test
        @DisplayName("1.1.1 Should create a new user account with ObjectMapper")
        void shouldCreateNewUserAccountWithObjectMapper() throws Exception {
            var user = UserAccountFixture.newUser();

            when(service.create(any())).thenReturn(user);

            var result = mvc.perform(post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ObjectMapperUtils.asJsonString(user)))
                  .andExpect(status().isCreated())
                  .andReturn();

            assertNotNull(result);

            var userResult = ObjectMapperUtils.fromJsonString(
                  result.getResponse().getContentAsString(), UserAccountResponseDto.class);

            assertEquals(user.getEmail(), userResult.getEmail());
            verify(service, times(1)).create(any());

        }

        @Test
        @DisplayName("1.1.2 Should create a new user account with FileReader")
        void shouldCreateNewUserAccountWithFileReader() throws Exception {
            var user = UserAccountFixture.newUser();
            when(service.create(any())).thenReturn(user);

            var result = mvc.perform(post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(FileReaderUtils.getJson("/request/user-account-create-request.json")))
                  .andExpect(status().isCreated())
                  .andReturn();

            assertNotNull(result);
            AssertJsonUtils.assertJsonEquals(FileReaderUtils.getJson("/response/user-account-create-response.json"),
                  result.getResponse().getContentAsString());
            verify(service, times(1)).create(any());

        }

        @Nested
        @DisplayName("2. Search user account")
        class SearchUserAccountTest {

            @Test
            @DisplayName("2.1 Search user should return data as expected")
            void searchUserAccountShouldReturnDataAsExpected() throws Exception {

                when(service.findAll(any(), any()))
                      .thenReturn(UserAccountFixture.newSearchResult());

                var result = mvc.perform(get(PATH)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("name", "m")
                            .param("email", "@email"))
                      .andExpect(status().isOk())
                      .andReturn();

                assertNotNull(result);
                verify(service, times(1)).findAll(any(), any());
                AssertJsonUtils.assertJsonEquals(result.getResponse().getContentAsString(),
                      FileReaderUtils.getJson("response/user-account-search-response.json"));
            }

            @Test
            @DisplayName("2.2 Search UserAccount with null search should return as expected")
            void searchUserAccountWithNullSearchShouldReturnAsExpected() throws Exception {

                when(service.findAll(any(), any()))
                      .thenReturn(UserAccountFixture.newEmptySearchResult());

                var result = mvc.perform(get(PATH)
                            .contentType(MediaType.APPLICATION_JSON)
                            .param("name", "a")
                            .param("email", "a"))
                      .andExpect(status().isOk())
                      .andReturn();

                assertNotNull(result);
                verify(service, times(1)).findAll(any(), any());
                AssertJsonUtils.assertJsonEquals(result.getResponse().getContentAsString(),
                      FileReaderUtils.getJson("response/user-account-empty-search-response.json"));
            }
        }
    }


}