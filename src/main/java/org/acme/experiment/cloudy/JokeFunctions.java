package org.acme.experiment.cloudy;

import io.quarkus.funqy.Funq;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.transaction.Transactional;
import java.util.List;

public class JokeFunctions {

    @Funq
    @Transactional
    public Uni<Integer> update(String category, String content) {
        return Uni.createFrom().item(category).onItem()
                .transform(n -> Joke.update("content=?1 where category=?2", content, category));
    }

    @Funq
    @Transactional
    public Joke make(Joke content) {
        Joke.persist(content);
        return content;
    }

    @Funq
    public List<Joke> findAll() {
        return Joke.listAll();
    }

}
