package com.murilobarbosa.java.modular.architecture.core.dto.base;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchResultDto<T> {

      private List<T> data;
      private Integer page;
      private Integer size;
      private Long totalElements;
      private Integer totalPages;
}
