package com.murilobarbosa.java.modular.architecture.core.dto.base;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageableDto {

    private Integer page;
    private Integer size;
}
