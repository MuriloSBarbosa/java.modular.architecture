package com.murilobarbosa.java.modular.architecture.application.controller.handler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

    private String message;
}
