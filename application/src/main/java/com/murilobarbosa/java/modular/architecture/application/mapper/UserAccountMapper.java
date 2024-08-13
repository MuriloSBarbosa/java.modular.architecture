package com.murilobarbosa.java.modular.architecture.application.mapper;

import com.murilobarbosa.java.modular.architecture.application.dto.request.SearchUserAccountRequestDto;
import com.murilobarbosa.java.modular.architecture.core.domain.UserAccount;
import com.murilobarbosa.java.modular.architecture.application.dto.request.UserAccountRequestDto;
import com.murilobarbosa.java.modular.architecture.application.dto.response.UserAccountResponseDto;
import com.murilobarbosa.java.modular.architecture.application.mapper.base.BaseRequestMapper;
import com.murilobarbosa.java.modular.architecture.application.mapper.base.BaseResponseMapper;
import com.murilobarbosa.java.modular.architecture.core.dto.SearchUserAccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UserAccountMapper
      extends BaseRequestMapper<UserAccount, UserAccountRequestDto>,
              BaseResponseMapper<UserAccount, UserAccountResponseDto> {

    SearchUserAccountDto toDomain(SearchUserAccountRequestDto searchUserAccountDto);

}
