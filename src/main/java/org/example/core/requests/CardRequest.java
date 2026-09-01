package org.example.core.requests;

import io.restassured.response.Response;
import org.example.core.entities.CardDTO;
import org.example.core.rest.Endpoints;
import org.example.core.rest.RequestSpecFactory;

import static io.restassured.RestAssured.given;

public class CardRequest {

    public Response CreateCard(CardDTO cartao) {
        return given()
                .spec(RequestSpecFactory.defaultRequestSpec())
                .body(cartao)
                .when()
                .post(Endpoints.CARDS);
    }
}
