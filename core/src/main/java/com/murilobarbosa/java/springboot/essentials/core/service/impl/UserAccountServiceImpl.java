package com.murilobarbosa.java.springboot.essentials.core.service.impl;

import com.murilobarbosa.java.springboot.essentials.core.domain.UserAccount;
import com.murilobarbosa.java.springboot.essentials.core.dto.SearchUserAccountDto;
import com.murilobarbosa.java.springboot.essentials.core.dto.base.PageableDto;
import com.murilobarbosa.java.springboot.essentials.core.dto.base.SearchResultDto;
import com.murilobarbosa.java.springboot.essentials.core.exception.UserAccountConflictException;
import com.murilobarbosa.java.springboot.essentials.core.persistence.UserAccountPersistence;
import com.murilobarbosa.java.springboot.essentials.core.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountPersistence persistence;

    @Override
    public UserAccount create(UserAccount userAccount) {
        if (this.persistence.existsByEmail(userAccount.getEmail())) {
            throw new UserAccountConflictException();
        }
        return this.persistence.create(userAccount);
    }

    @Override
    public SearchResultDto<UserAccount> findAll(SearchUserAccountDto search, PageableDto page) {
        return this.persistence.findAll(search, page);
    }

}
