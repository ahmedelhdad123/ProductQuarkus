package com.product.Quarkus.excption;

import jakarta.ws.rs.ext.Provider;

@Provider
public class ProductException extends RuntimeException {

    public ProductException(String message) {
        super(message);
    }
}
