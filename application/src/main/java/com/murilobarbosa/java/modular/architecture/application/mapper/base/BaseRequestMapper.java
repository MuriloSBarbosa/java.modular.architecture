package com.murilobarbosa.java.modular.architecture.application.mapper.base;

public interface BaseRequestMapper<D, R> {

    D toDomain(R request);

    R toRequest(D domain);
}
