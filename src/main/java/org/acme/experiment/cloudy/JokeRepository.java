package org.acme.experiment.cloudy;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class JokeRepository implements PanacheRepository<Joke> {

    @Transactional
    public int update(String content, String category) {
        return update("content= :content where category= :category",
                      Parameters.with("content", content).and("category", category));
    }
}
