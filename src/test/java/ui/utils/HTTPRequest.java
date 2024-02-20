package ui.utils;

import static io.restassured.RestAssured.given;

public class HTTPRequest {

    public int getStatusCodeFromSrc(String url) {
        return given()
                .accept("*/*")
                .when()
                .get(url)
                .then()
                .extract().response().getStatusCode();
    }
}
