package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class WizardClientResourceTest {
    @Test
    void testWorkEndpoint() {
        given()
          .when().get("/wizard-client/work")
          .then()
             .statusCode(200)
             .body(is("Work done!"));
    }

}