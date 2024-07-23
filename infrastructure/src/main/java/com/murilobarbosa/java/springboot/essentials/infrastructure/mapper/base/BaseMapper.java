package com.murilobarbosa.java.springboot.essentials.infrastructure.mapper.base;

import com.murilobarbosa.java.springboot.essentials.core.dto.base.PageableDto;
import com.murilobarbosa.java.springboot.essentials.core.dto.base.SearchResultDto;
import java.util.List;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseMapper<E, D> {

    E toEntity(D dto);

    List<E> toEntity(List<D> dtoList);


    @Mapping(target = "data", source = "page", qualifiedByName = "getData")
    @Mapping(target = "page", source = "page", qualifiedByName = "getPageNumber")
    @Mapping(target = "size", source = "page", qualifiedByName = "getSize")
    @Mapping(target = "totalElements", source = "page.totalElements")
    @Mapping(target = "totalPages", source = "page.totalPages")
    SearchResultDto<D> toDomain (Page<E> page);

    @Named("getData")
    default List<D> getData(Page<E> page) {
        return toDomain(page.getContent());
    }

    @Named("getPageNumber")
    default Integer getPageNumber(Page<E> page) {
        return page.getNumber();
    }

    @Named("getSize")
    default Integer getSize(Page<E> page) {
        return page.getNumberOfElements();
    }


    D toDomain(E entity);

    List<D> toDomain(List<E> entityList);

}
