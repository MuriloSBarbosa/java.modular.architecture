package com.murilobarbosa.java.springboot.essentials.infrastructure.adapter;

import com.murilobarbosa.java.springboot.essentials.core.domain.UserAccount;
import com.murilobarbosa.java.springboot.essentials.core.dto.SearchUserAccountDto;
import com.murilobarbosa.java.springboot.essentials.core.dto.base.PageableDto;
import com.murilobarbosa.java.springboot.essentials.core.dto.base.SearchResultDto;
import com.murilobarbosa.java.springboot.essentials.infrastructure.mapper.UserAccountEntityMapper;
import com.murilobarbosa.java.springboot.essentials.infrastructure.repository.UserAccountRepository;
import com.murilobarbosa.java.springboot.essentials.core.persistence.UserAccountPersistence;
import com.murilobarbosa.java.springboot.essentials.infrastructure.specification.UserAccountSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserAccountAdapter implements UserAccountPersistence {

    private final UserAccountRepository repository;
    private final UserAccountEntityMapper mapper;

    @Override
    public UserAccount create(UserAccount userAccount) {
        return this.mapper.toDomain(this.repository.save(this.mapper.toEntity(userAccount)));
    }

    @Override
    public boolean existsByEmail(String email) {
        return this.repository.existsByEmail(email);
    }

    @Override
    public SearchResultDto<UserAccount> findAll(SearchUserAccountDto search, PageableDto page) {
        var specification = UserAccountSpecification.filter(search);

        return this.mapper.toDomain(
              this.repository.findAll(specification,
                    PageRequest.of(page.getPage(), page.getSize())));
    }
}
