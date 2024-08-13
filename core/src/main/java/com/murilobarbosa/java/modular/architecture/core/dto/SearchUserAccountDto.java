package com.murilobarbosa.java.modular.architecture.core.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchUserAccountDto  {

    private String name;
    private String email;
}
