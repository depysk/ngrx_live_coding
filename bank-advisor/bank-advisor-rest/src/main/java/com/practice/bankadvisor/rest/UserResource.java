package com.practice.bankadvisor.rest;

import com.practice.bankadvisor.core.dto.UserDto;
import com.practice.bankadvisor.core.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;

@Component
@Path("/users")
@Produces(APPLICATION_JSON)
public class UserResource {

    private UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("/all")
    @Consumes(APPLICATION_JSON)
    public Response users() {

        List<UserDto> userDtos = userService.findAll();

        return Response.status(OK)
                .entity(userDtos)
                .build();
    }

    @GET
    @Path("/{id}/selected")
    @Consumes(APPLICATION_JSON)
    public Response selectedUser(@PathParam("id") Long id) {

        UserDto userDto = userService.getSelectedUser(id);

        return Response.status(OK)
                .entity(userDto)
                .build();
    }

    @POST
    @Path("/{id}/update")
    @Consumes(APPLICATION_JSON)
    public Response updateUser(@PathParam("id") Long id, UserDto userDto) {

        UserDto updatedUserDto = userService.updateUser(userDto);

        return Response.status(OK)
                .entity(updatedUserDto)
                .build();
    }
}
