package org.example.core.requests;

import io.restassured.response.Response;
import org.example.core.rest.Endpoints;
import org.example.core.rest.RequestSpecFactory;
import org.example.core.entities.SimulationDTO;

import static io.restassured.RestAssured.given;

public class SimulationRequest {

    public Response simularCredito(SimulationDTO simulation) {
        return given()
                .spec(RequestSpecFactory.defaultRequestSpec())
                .body(simulation)
                .when()
                .post(Endpoints.SIMULATIONS);
    }
}