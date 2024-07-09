package com.product.Quarkus.rest;

import com.product.Quarkus.entity.Product;
import com.product.Quarkus.service.ProductService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    ProductService productService;

    @GET
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @GET
    @Path("/{id}")
    public Product getProduct(@PathParam("id") int id) {
        return productService.findById(id);
    }


    @POST
    public void addProduct(@Valid Product product) {
        productService.save(product);
    }

    @PUT
    @Path("/{id}")
    public void updateProduct(@PathParam("id") int id, Product product) {
        productService.updateProduct(id, product);
    }

    @DELETE
    @Path("/{id}")
    public void deleteProduct(@PathParam("id") int id) {
        productService.deleteById(id);
    }
}
