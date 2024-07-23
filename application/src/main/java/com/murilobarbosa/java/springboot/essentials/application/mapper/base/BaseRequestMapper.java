package com.murilobarbosa.java.springboot.essentials.application.mapper.base;

public interface BaseRequestMapper<D, R> {

    D toDomain(R request);

    R toRequest(D domain);
}
