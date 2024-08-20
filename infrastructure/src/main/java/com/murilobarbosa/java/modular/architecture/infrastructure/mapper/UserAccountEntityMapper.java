package com.murilobarbosa.java.modular.architecture.infrastructure.mapper;

import com.murilobarbosa.java.modular.architecture.infrastructure.entity.UserAccountEntity;
import com.murilobarbosa.java.modular.architecture.infrastructure.mapper.base.BaseMapper;
import com.murilobarbosa.java.modular.architecture.core.domain.UserAccount;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UserAccountEntityMapper extends BaseMapper<UserAccountEntity, UserAccount> {

}
