package com.murilobarbosa.java.springboot.essentials.core.service;

import com.murilobarbosa.java.springboot.essentials.core.domain.UserAccount;
import com.murilobarbosa.java.springboot.essentials.core.dto.SearchUserAccountDto;
import com.murilobarbosa.java.springboot.essentials.core.dto.base.PageableDto;
import com.murilobarbosa.java.springboot.essentials.core.dto.base.SearchResultDto;

public interface UserAccountService {

    UserAccount create(UserAccount userAccount);

    SearchResultDto<UserAccount> findAll(SearchUserAccountDto search, PageableDto page);
}
