package com.murilobarbosa.java.springboot.essentials.application.mapper;

import com.murilobarbosa.java.springboot.essentials.application.dto.request.SearchUserAccountRequestDto;
import com.murilobarbosa.java.springboot.essentials.core.domain.UserAccount;
import com.murilobarbosa.java.springboot.essentials.application.dto.request.UserAccountRequestDto;
import com.murilobarbosa.java.springboot.essentials.application.dto.response.UserAccountResponseDto;
import com.murilobarbosa.java.springboot.essentials.application.mapper.base.BaseRequestMapper;
import com.murilobarbosa.java.springboot.essentials.application.mapper.base.BaseResponseMapper;
import com.murilobarbosa.java.springboot.essentials.core.dto.SearchUserAccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UserAccountMapper
      extends BaseRequestMapper<UserAccount, UserAccountRequestDto>,
              BaseResponseMapper<UserAccount, UserAccountResponseDto> {

    SearchUserAccountDto toDomain(SearchUserAccountRequestDto searchUserAccountDto);

}
