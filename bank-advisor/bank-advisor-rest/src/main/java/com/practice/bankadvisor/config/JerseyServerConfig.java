package com.practice.bankadvisor.config;

import com.practice.bankadvisor.filter.CORSResponseFilter;
import com.practice.bankadvisor.rest.WebExceptionHandler;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class JerseyServerConfig extends ResourceConfig {

    public JerseyServerConfig() {
        packages("com.practice.bankadvisor.rest");

        Set<Class<?>> configurations = new HashSet<>();
        configurations.add(CORSResponseFilter.class);
        configurations.add(WebExceptionHandler.class);

        registerClasses(configurations);
    }
}
