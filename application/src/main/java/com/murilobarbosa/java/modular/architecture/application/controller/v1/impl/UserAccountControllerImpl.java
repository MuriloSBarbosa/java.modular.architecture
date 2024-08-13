package com.murilobarbosa.java.modular.architecture.application.controller.v1.impl;

import com.murilobarbosa.java.modular.architecture.application.controller.v1.UserAccountController;
import com.murilobarbosa.java.modular.architecture.application.dto.request.SearchUserAccountRequestDto;
import com.murilobarbosa.java.modular.architecture.application.dto.request.UserAccountRequestDto;
import com.murilobarbosa.java.modular.architecture.application.dto.response.SearchResultResponseDto;
import com.murilobarbosa.java.modular.architecture.application.dto.response.UserAccountResponseDto;
import com.murilobarbosa.java.modular.architecture.application.mapper.UserAccountMapper;
import com.murilobarbosa.java.modular.architecture.application.mapper.base.PageableMapper;
import com.murilobarbosa.java.modular.architecture.application.utils.UriBuilder;
import com.murilobarbosa.java.modular.architecture.core.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserAccountControllerImpl implements
      UserAccountController {

    private final UserAccountService service;
    private final UserAccountMapper mapper;
    private final PageableMapper pageableMapper;

    @Override
    public ResponseEntity<UserAccountResponseDto> create(
          UserAccountRequestDto userAccountRequestDto) {
        var userAccount = this.service.create(this.mapper.toDomain(userAccountRequestDto));
        var uri = UriBuilder.build(userAccount.getId());
        return ResponseEntity.created(uri).body(this.mapper.toResponse(userAccount));
    }

    @Override
    public ResponseEntity<SearchResultResponseDto<UserAccountResponseDto>> get(
          SearchUserAccountRequestDto searchUserAccountDto,
          Pageable pageable) {

        var page = this.pageableMapper.toDomain(pageable);
        var search = this.mapper.toDomain(searchUserAccountDto);

        var userAccount = this.service.findAll(search, page);

        return ResponseEntity.ok(this.mapper.toResponse(userAccount));
    }
}
