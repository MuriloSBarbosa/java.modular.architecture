package com.murilobarbosa.java.springboot.essentials.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserAccountRequestDto {

    @Schema(description = "User name", example = "John Doe")
    @NotBlank
    private String name;

    @Schema(description = "User email", example = "john.doe@email.com")
    @Email
    @NotBlank
    private String email;

    @Schema(description = "User password", example = "password")
    @NotBlank
    private String password;
}
