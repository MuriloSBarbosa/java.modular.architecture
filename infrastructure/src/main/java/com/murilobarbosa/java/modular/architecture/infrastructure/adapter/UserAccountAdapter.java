package com.murilobarbosa.java.modular.architecture.infrastructure.adapter;

import com.murilobarbosa.java.modular.architecture.infrastructure.mapper.UserAccountEntityMapper;
import com.murilobarbosa.java.modular.architecture.infrastructure.repository.UserAccountRepository;
import com.murilobarbosa.java.modular.architecture.infrastructure.specification.UserAccountSpecification;
import com.murilobarbosa.java.modular.architecture.core.domain.UserAccount;
import com.murilobarbosa.java.modular.architecture.core.dto.SearchUserAccountDto;
import com.murilobarbosa.java.modular.architecture.core.dto.base.PageableDto;
import com.murilobarbosa.java.modular.architecture.core.dto.base.SearchResultDto;
import com.murilobarbosa.java.modular.architecture.core.persistence.UserAccountPersistence;
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
