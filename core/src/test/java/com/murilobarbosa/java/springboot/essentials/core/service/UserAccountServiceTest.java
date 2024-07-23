package com.murilobarbosa.java.springboot.essentials.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.murilobarbosa.java.springboot.essentials.core.dto.base.PageableDto;
import com.murilobarbosa.java.springboot.essentials.core.exception.UserAccountConflictException;
import com.murilobarbosa.java.springboot.essentials.core.fixture.UserAccountFixture;
import com.murilobarbosa.java.springboot.essentials.core.persistence.UserAccountPersistence;
import com.murilobarbosa.java.springboot.essentials.core.service.impl.UserAccountServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserAccountServiceTest {

    @Mock
    private UserAccountPersistence persistence;

    @InjectMocks
    private UserAccountServiceImpl service;

    @Nested
    @DisplayName("1. Create UserAccount")
    class UserAccountManipulation {

        @Test
        @DisplayName("1.1 Create UserAccount should return as expected")
        void createUserAccountShouldReturnAsExpected() {
            var userAccount = UserAccountFixture.newUser();

            when(persistence.create(any())).thenReturn(userAccount);

            var result = service.create(userAccount);

            assertNotNull(result);
            assertEquals(userAccount, result);
            verify(persistence,times(1)).create(any());
        }

        @Test
        @DisplayName("1.2 Create conflicted UserAccount should throw error")
        void createConflictedUserAccountShouldThrowError() {
            var user = UserAccountFixture.newUser();

            when(persistence.existsByEmail(user.getEmail())).thenReturn(true);

            assertThrows(UserAccountConflictException.class, () -> service.create(user));
            verify(persistence,times(0)).create(any());
        }

    }

    @Nested
    @DisplayName("2. Search UserAccount")
    class UserAccountSearch {

        @Test
        @DisplayName("2.1 Find all UserAccount should return as expected")
        void findAllUserAccountShouldReturnAsExpected() {
            var search = UserAccountFixture.newSearch();
            var page = PageableDto.builder().page(0).size(10).build();
            var result = UserAccountFixture.newSearchResult();

            when(persistence.findAll(search, page)).thenReturn(result);

            var searchResult = service.findAll(search, page);

            assertNotNull(searchResult);
            assertEquals(result, searchResult);
            verify(persistence,times(1)).findAll(search, page);
        }

        @Test
        @DisplayName("2.2 Find all UserAccount with null search should return as expected")
        void findAllUserAccountWithNullSearchShouldReturnAsExpected() {
            var page = PageableDto.builder().page(0).size(10).build();
            var result = UserAccountFixture.newSearchResult();

            when(persistence.findAll(null, page)).thenReturn(result);

            var searchResult = service.findAll(null, page);

            assertNotNull(searchResult);
            assertEquals(result, searchResult);
            verify(persistence,times(1)).findAll(null, page);
        }

    }

}