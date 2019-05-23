package com.exercise.exception;

public class NumberConvertException extends Exception {

    private static final long serialVersionUID = 1L;

    public NumberConvertException() {
        super();
    }

    public NumberConvertException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    public NumberConvertException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public NumberConvertException(String arg0) {
        super(arg0);
    }

    public NumberConvertException(Throwable arg0) {
        super(arg0);
    }
}
