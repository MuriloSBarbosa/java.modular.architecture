package com.murilobarbosa.java.springboot.essentials.application.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class SearchResultResponseDto<T> {

    private List<T> data;
    private Integer page;
    private Integer size;
    private Long totalElements;
    private Integer totalPages;
}
