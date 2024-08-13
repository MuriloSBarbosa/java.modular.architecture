package com.murilobarbosa.java.modular.architecture.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SearchUserAccountRequestDto {

    @Schema(description = "Condition to filter user by name or email", example = "Murilo")
    private String name;

    @Schema(description = "Condition to filter user by name or email", example = "murilo@email.com")
    private String email;
}
