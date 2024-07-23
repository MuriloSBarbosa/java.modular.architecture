package com.murilobarbosa.java.springboot.essentials.application.utils;

import java.net.URI;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class UriBuilder {

    public UriBuilder() {
        throw new IllegalStateException("Utility class");
    }

    public static URI build(Object id) {
        return ServletUriComponentsBuilder
              .fromCurrentRequest()
              .path("/{id}")
              .buildAndExpand(id)
              .toUri();
    }
}
