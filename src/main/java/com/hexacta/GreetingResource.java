package com.hexacta;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    private GreetingServices service;

    @Inject
    public GreetingResource(GreetingServices service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{name}")
    public String hello(@PathParam String name) {
        return this.service.greeting(name);
    }

    @POST
    @Path("/save/{greeting}")
    public int saveGreeting(@PathParam String greeting) {
        return this.service.saveGreeting(greeting);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{id}/{name}")
    public String hello(@PathParam int id,@PathParam String name) {
        return this.service.greeting(id, name);
    }


}