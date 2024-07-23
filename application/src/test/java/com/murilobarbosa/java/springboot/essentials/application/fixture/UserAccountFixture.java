package com.murilobarbosa.java.springboot.essentials.application.fixture;

import com.murilobarbosa.java.springboot.essentials.core.domain.UserAccount;
import com.murilobarbosa.java.springboot.essentials.core.dto.SearchUserAccountDto;
import com.murilobarbosa.java.springboot.essentials.core.dto.base.SearchResultDto;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class UserAccountFixture {

    public static UserAccount newUser() {
        return UserAccount.builder()
              .id(UUID.fromString("f47b1f1f-7e1c-4f1d-9b0f-0f1f1f1f1f1f"))
              .name("Murilo Barbosa")
              .email("murilo.barbosa@email.com")
              .password("123")
              .build();
    }

    public static SearchUserAccountDto newSearchRequest() {
        return SearchUserAccountDto.builder()
              .name("M")
              .build();
    }

    public static SearchResultDto<UserAccount> newSearchResult() {
        return SearchResultDto.<UserAccount>builder()
              .page(0)
              .size(10)
              .data(List.of(newUser()))
              .totalElements(1L)
              .totalPages(1)
              .build();
    }

    public static SearchResultDto<UserAccount> newEmptySearchResult() {
        return SearchResultDto.<UserAccount>builder()
              .page(0)
              .size(10)
              .data(List.of())
              .totalElements(0L)
              .totalPages(1)
              .build();
    }
}
