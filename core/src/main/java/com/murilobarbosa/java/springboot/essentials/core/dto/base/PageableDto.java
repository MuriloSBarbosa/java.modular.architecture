package com.murilobarbosa.java.springboot.essentials.core.dto.base;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageableDto {

    private Integer page;
    private Integer size;
}
