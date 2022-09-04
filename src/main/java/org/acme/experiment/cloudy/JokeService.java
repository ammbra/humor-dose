package org.acme.experiment.cloudy;


import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestQuery;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.inject.Singleton;

@RegisterRestClient
@Singleton
@Path("jokes")
public interface JokeService {

    @GET
    @Path("random")
    @Produces(MediaType.APPLICATION_JSON)
    FunnyContent getAny(@RestQuery("category") String category);


}
