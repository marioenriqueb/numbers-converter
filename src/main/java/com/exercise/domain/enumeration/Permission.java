package com.exercise.domain.enumeration;

import com.exercise.exception.NumberConvertException;

import javax.persistence.Entity;
import java.util.Arrays;

/**
 * The Permission enumeration.
 */
public enum Permission {
    BINARIO("BINARIO"),
    HEXADECIMAL("HEXADECIMAL"),
    DECIMAL("DECIMAL"),
    ROMANO("ROMANO"),
    MASTER("MASTER");

    private String code;

    Permission(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return name().toUpperCase();
    }

    public static Permission byCode(String code) throws NumberConvertException {
        return Arrays.stream(Permission.values())
                .filter(e -> e.code.equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new NumberConvertException(String.format("Unsupported type %s.", code)));
    }
}
