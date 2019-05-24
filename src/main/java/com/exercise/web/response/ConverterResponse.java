package com.exercise.web.response;

import com.exercise.domain.enumeration.Permission;

public class ConverterResponse {
    private String number;
    private Permission target;
    private String result;

    public ConverterResponse(String number, String result, Permission target) {
        this.number = number;
        this.target = target;
        this.result = result;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Permission getTarget() {
        return target;
    }

    public void setTarget(Permission target) {
        this.target = target;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
