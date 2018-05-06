package com.practice.bankadvisor.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.ArrayList;
import java.util.List;


public class WebExceptionHandler implements ExceptionMapper<Throwable> {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebExceptionHandler.class);

    @Override
    public Response toResponse(Throwable throwable) {

        ErrorMessage errorMessage = new ErrorMessage();
        setHttpStatus(throwable, errorMessage);
        errorMessage.addMessage("LocalizedMessage = " + throwable.getLocalizedMessage());
        errorMessage.addMessage("Message = " + throwable.getMessage());

        LOGGER.error(throwable.getMessage(), throwable);

        return Response.status(errorMessage.getStatus())
                       .entity(errorMessage)
                       .type(MediaType.APPLICATION_JSON)
                       .build();
    }

    private void setHttpStatus(Throwable throwable, ErrorMessage errorMessage) {
        if (throwable instanceof WebApplicationException) {
            errorMessage.setStatus(((WebApplicationException) throwable).getResponse().getStatusInfo());
        } else {
            errorMessage.setStatus(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    private static class ErrorMessage {
        private Response.StatusType status;

        private List<String> messages = new ArrayList<>();

        Response.StatusType getStatus() {
            return status;
        }

        void setStatus(Response.StatusType status) {
            this.status = status;
        }

        public List<String> getMessages() {
            return messages;
        }

        void addMessage(String message) {
            this.messages.add(message);
        }
    }

}
