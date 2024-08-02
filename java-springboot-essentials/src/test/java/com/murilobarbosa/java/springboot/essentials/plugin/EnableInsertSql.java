package com.murilobarbosa.java.springboot.essentials.plugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.extension.ExtendWith;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith({EnableInsertSqlImpl.class})
public @interface EnableInsertSql {

    boolean alwaysCleanAfter() default false;
}
