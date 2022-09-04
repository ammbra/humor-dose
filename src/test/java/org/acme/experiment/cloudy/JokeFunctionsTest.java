package org.acme.experiment.cloudy;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
public class JokeFunctionsTest {

    @Test
    public void testFindAll() {
        given()
            .post("/findAll")
            .then()
            .statusCode(200)
            .body(notNullValue());
    }

}
