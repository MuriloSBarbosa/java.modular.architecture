package com.murilobarbosa.java.springboot.essentials.infrastructure.mapper;

import com.murilobarbosa.java.springboot.essentials.infrastructure.entity.UserAccountEntity;
import com.murilobarbosa.java.springboot.essentials.infrastructure.mapper.base.BaseMapper;
import com.murilobarbosa.java.springboot.essentials.core.domain.UserAccount;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UserAccountEntityMapper extends BaseMapper<UserAccountEntity, UserAccount> {

}
