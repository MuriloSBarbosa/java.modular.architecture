package com.murilobarbosa.java.springboot.essentials.core.exception;

import com.murilobarbosa.java.springboot.essentials.core.exception.base.ConflictException;

public class UserAccountConflictException extends ConflictException {

    public static final String MESSAGE = "User account already exists";

    public UserAccountConflictException() {
        super(MESSAGE);
    }
}
