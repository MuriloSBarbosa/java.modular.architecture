package com.murilobarbosa.java.modular.architecture.core.exception;

import com.murilobarbosa.java.modular.architecture.core.exception.base.ConflictException;

public class UserAccountConflictException extends ConflictException {

    public static final String MESSAGE = "User account already exists";

    public UserAccountConflictException() {
        super(MESSAGE);
    }
}
