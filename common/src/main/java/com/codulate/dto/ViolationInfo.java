package com.codulate.dto;

import java.io.Serializable;

public class ViolationInfo implements Serializable {
    private String message;

    public ViolationInfo() {
    }

    public ViolationInfo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
