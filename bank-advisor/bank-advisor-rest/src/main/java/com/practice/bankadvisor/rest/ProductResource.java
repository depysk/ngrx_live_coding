package com.practice.bankadvisor.rest;

import com.practice.bankadvisor.core.dto.ProductDto;
import com.practice.bankadvisor.core.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;

@Component
@Path("/products")
@Produces(APPLICATION_JSON)
public class ProductResource {

    private ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GET
    @Path("/all")
    @Consumes(APPLICATION_JSON)
    public Response products() {

        List<ProductDto> productDtos = productService.findAll();

        return Response.status(OK)
                .entity(productDtos)
                .build();
    }

    @GET
    @Path("/{id}/selected")
    @Consumes(APPLICATION_JSON)
    public Response selectedProduct(@PathParam("id") Long id) {

        ProductDto productDto = productService.getSelectedProduct(id);

        return Response.status(OK)
                .entity(productDto)
                .build();
    }
}
