package org.agoncal.quarkus.microservices.book;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;

@QuarkusTest
class BookResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
                .formParam("title", "Understanding Quarkus")
                .formParam("author", "Antonio")
                .formParam("year", "1995")
                .formParam("genre", "IT")
          .when()
                .post("/api/books")
          .then()
             .statusCode(200)
             .body("isbn_13", startsWith("13-"))
             .body("title", startsWith("Understanding Quarkus"))
             .body("author", is("Antonio"))
             .body("year", is("1995"))
             .body("genre", is("IT"))
             .body("creation_date", startsWith("22"));
    }

}