package com.murilobarbosa.java.springboot.essentials.application.mapper.base;

import com.murilobarbosa.java.springboot.essentials.application.dto.response.SearchResultResponseDto;
import com.murilobarbosa.java.springboot.essentials.core.dto.base.SearchResultDto;
import java.util.List;

public interface BaseResponseMapper<D, R> {

    R toResponse(D domain);

    List<R> toResponse(List<D> domain);

    SearchResultResponseDto<R> toResponse(SearchResultDto<D> domain);


}
