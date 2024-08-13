package com.murilobarbosa.java.modular.architecture.application.dto.response;

import java.util.UUID;
import lombok.Data;

@Data
public class UserAccountResponseDto {

    private UUID id;
    private String name;
    private String email;
}
