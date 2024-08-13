package com.murilobarbosa.java.modular.architecture.application.mapper.base;

import com.murilobarbosa.java.modular.architecture.core.dto.base.PageableDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.Named;
import org.springframework.data.domain.Pageable;

@Mapper(componentModel = ComponentModel.SPRING)
public interface PageableMapper {

    @Mapping(target = "page", source = "pageable", qualifiedByName = "getPageNumber")
    @Mapping(target = "size", source = "pageable", qualifiedByName = "getPageSize")
    PageableDto toDomain(Pageable pageable);

    @Named("getPageNumber")
    default Integer getPageNumber(Pageable pageable) {
        return pageable.getPageNumber();
    }

    @Named("getPageSize")
    default Integer getPageSize(Pageable pageable) {
        return pageable.getPageSize();
    }

}
