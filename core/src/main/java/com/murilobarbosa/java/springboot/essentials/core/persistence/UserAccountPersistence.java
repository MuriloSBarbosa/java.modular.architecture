package com.murilobarbosa.java.springboot.essentials.core.persistence;

import com.murilobarbosa.java.springboot.essentials.core.domain.UserAccount;
import com.murilobarbosa.java.springboot.essentials.core.dto.SearchUserAccountDto;
import com.murilobarbosa.java.springboot.essentials.core.dto.base.PageableDto;
import com.murilobarbosa.java.springboot.essentials.core.dto.base.SearchResultDto;
import java.util.Optional;

public interface UserAccountPersistence {

    UserAccount create(UserAccount userAccount);

    boolean existsByEmail(String email);

    SearchResultDto<UserAccount> findAll(SearchUserAccountDto search, PageableDto page);
}
