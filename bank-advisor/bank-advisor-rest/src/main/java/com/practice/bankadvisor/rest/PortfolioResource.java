package com.practice.bankadvisor.rest;
import com.practice.bankadvisor.core.dto.PortfolioDto;
import com.practice.bankadvisor.core.service.portfolio.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;

@Component
@Path("/portfolios")
@Produces(APPLICATION_JSON)
public class PortfolioResource {

    private PortfolioService portfolioService;

    @Autowired
    public PortfolioResource(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GET
    @Path("/all")
    @Consumes(APPLICATION_JSON)
    public Response portfolios() {

        List<PortfolioDto> portfolioDtos = portfolioService.findAll();

        return Response.status(OK)
                .entity(portfolioDtos)
                .build();
    }

    @GET
    @Path("/{id}/selected")
    @Consumes(APPLICATION_JSON)
    public Response selectedPortfolio(@PathParam("id") Long id) {

        PortfolioDto portfolioDto = portfolioService.getSelectedPortfolio(id);

        return Response.status(OK)
                .entity(portfolioDto)
                .build();
    }

    @DELETE
    @Path("/{portfolioId}/delete-user/{userId}")
    @Consumes(APPLICATION_JSON)
    public Response removeUserFromPortfolio(@PathParam("portfolioId") Long portfolioId, @PathParam("userId") Long userId) {

        portfolioService.removeUserFromPortfolio(portfolioId, userId);

        return Response.status(OK)
                .entity(userId)
                .build();
    }
}
