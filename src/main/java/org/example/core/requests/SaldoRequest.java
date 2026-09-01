package org.example.core.requests;

import io.restassured.response.Response;
import org.example.core.entities.SaldoDTO;
import org.example.core.rest.Endpoints;
import org.example.core.rest.RequestSpecFactory;

import static io.restassured.RestAssured.given;

public class SaldoRequest {

    public Response consultaSaldo() {
        return given()
                .when()
                .get(Endpoints.SIMULATINS_SALDO);
    }
}
