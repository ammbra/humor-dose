package org.acme.experiment.cloudy;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.reactive.RestPath;

import java.util.List;

@Path("/jokes")
public class JokeResource {

    @PUT
    @Path("{category}/{content}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Uni<Integer> update(@RestPath String category, @RestPath  String content) {
        return Uni.createFrom().item(category).onItem()
                .transform(n -> Joke.update("content=?1 where category=?2", content, category));
    }

    @POST
    @Transactional
    public Joke make(Joke content) {
        Joke.persist(content);
        return content;
    }

    @GET
    public List<Joke> findAll() {
        return Joke.listAll();
    }
}