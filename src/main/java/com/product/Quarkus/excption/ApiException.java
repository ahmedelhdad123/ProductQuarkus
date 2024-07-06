package com.product.Quarkus.excption;

import jakarta.transaction.Status;

public class ApiException {

    private String message;

    public ApiException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
