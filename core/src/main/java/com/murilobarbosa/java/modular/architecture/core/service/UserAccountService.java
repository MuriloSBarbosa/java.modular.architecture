package com.murilobarbosa.java.modular.architecture.core.service;

import com.murilobarbosa.java.modular.architecture.core.domain.UserAccount;
import com.murilobarbosa.java.modular.architecture.core.dto.SearchUserAccountDto;
import com.murilobarbosa.java.modular.architecture.core.dto.base.PageableDto;
import com.murilobarbosa.java.modular.architecture.core.dto.base.SearchResultDto;

public interface UserAccountService {

    UserAccount create(UserAccount userAccount);

    SearchResultDto<UserAccount> findAll(SearchUserAccountDto search, PageableDto page);
}
