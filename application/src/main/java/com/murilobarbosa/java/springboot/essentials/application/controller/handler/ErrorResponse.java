package com.murilobarbosa.java.springboot.essentials.application.controller.handler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

    private String message;
}
