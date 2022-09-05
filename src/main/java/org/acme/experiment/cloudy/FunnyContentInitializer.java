package org.acme.experiment.cloudy;

import io.quarkus.arc.profile.UnlessBuildProfile;
import io.quarkus.runtime.Startup;
import org.eclipse.microprofile.rest.client.inject.RestClient;


import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import org.jboss.logging.Logger;

@Startup
@ApplicationScoped
@UnlessBuildProfile("test")
public class FunnyContentInitializer {


    @Inject
    Logger LOGGER;

    @RestClient
    JokeService jokeService;

    @Inject
    JokeRepository repository;

    @PostConstruct
    public void init() {
        LOGGER.debug("Updating the db from external service");
        List<Joke> jokes = Joke.listAll();
        for (Joke joke : jokes) {
            String category = joke.category;
            repository.update(jokeService.getAny(category).value(), category);
        }
        LOGGER.debug("End update of the db");
    }
}