package com.exercise.domain.enumeration;

import com.exercise.exception.NumberConvertException;

import javax.persistence.Entity;
import java.util.Arrays;

/**
 * The Permission enumeration.
 */
public enum Permission {
    BINARIO("B"),
    HEXADECIMAL("H"),
    DECIMAL("D"),
    ROMANO("R"),
    MASTER("M");

    private String code;

    Permission(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }

    public static Permission byCode(String code) throws NumberConvertException {
        return Arrays.stream(Permission.values())
                .filter(e -> e.code.equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new NumberConvertException(String.format("Unsupported type %s.", code)));
    }
}
