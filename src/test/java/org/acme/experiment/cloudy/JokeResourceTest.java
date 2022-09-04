package org.acme.experiment.cloudy;

import io.quarkus.test.junit.QuarkusTest;
import jdk.dynalink.linker.support.Guards;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class JokeResourceTest {

    @Test
    public void testFindAll() {
        given()
          .when().get("/jokes")
          .then()
             .statusCode(200)
             .body(notNullValue());
    }

}