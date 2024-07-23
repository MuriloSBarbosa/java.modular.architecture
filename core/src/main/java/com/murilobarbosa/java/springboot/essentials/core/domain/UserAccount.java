package com.murilobarbosa.java.springboot.essentials.core.domain;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
