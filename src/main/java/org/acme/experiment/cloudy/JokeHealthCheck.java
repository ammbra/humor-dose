package org.acme.experiment.cloudy;

import org.eclipse.microprofile.health.HealthCheck;


import io.smallrye.health.checks.UrlHealthCheck;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.HttpMethod;

@ApplicationScoped
public class JokeHealthCheck {

    @ConfigProperty(name = "quarkus.rest-client.\"org.acme.experiment.cloudy.JokeService\".url")
    String externalURL;

    @Readiness
    HealthCheck checkURL() {
        return new UrlHealthCheck(externalURL+"/jokes/random")
                .name("external-url-check").requestMethod(HttpMethod.GET).statusCode(200);
    }

}