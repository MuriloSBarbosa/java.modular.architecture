package com.murilobarbosa.java.modular.architecture.application.mapper.base;

import com.murilobarbosa.java.modular.architecture.application.dto.response.SearchResultResponseDto;
import com.murilobarbosa.java.modular.architecture.core.dto.base.SearchResultDto;
import java.util.List;

public interface BaseResponseMapper<D, R> {

    R toResponse(D domain);

    List<R> toResponse(List<D> domain);

    SearchResultResponseDto<R> toResponse(SearchResultDto<D> domain);


}
