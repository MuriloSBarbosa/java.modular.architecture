package com.murilobarbosa.java.modular.architecture.core.persistence;

import com.murilobarbosa.java.modular.architecture.core.domain.UserAccount;
import com.murilobarbosa.java.modular.architecture.core.dto.SearchUserAccountDto;
import com.murilobarbosa.java.modular.architecture.core.dto.base.PageableDto;
import com.murilobarbosa.java.modular.architecture.core.dto.base.SearchResultDto;

public interface UserAccountPersistence {

    UserAccount create(UserAccount userAccount);

    boolean existsByEmail(String email);

    SearchResultDto<UserAccount> findAll(SearchUserAccountDto search, PageableDto page);
}
