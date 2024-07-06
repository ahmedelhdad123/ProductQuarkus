package com.product.Quarkus.excption;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Throwable> {


    @Override
    public Response toResponse(Throwable throwable) {
        ApiException apiException=new ApiException(throwable.getMessage());

        int statusCode = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        if (throwable instanceof ProductException) {
            statusCode = Response.Status.BAD_REQUEST.getStatusCode();
        }

        return Response.status(statusCode)
                .entity(apiException)
                .build();
    }
}
