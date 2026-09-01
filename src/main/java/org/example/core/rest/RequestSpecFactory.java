package org.example.core.rest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecFactory {

    private static final String AUTH_TOKEN = System.getenv().getOrDefault("API_TOKEN", "seu_token_jwt_aqui");

    public static RequestSpecification defaultRequestSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + AUTH_TOKEN)
                .addHeader("X-Channel", "INTERNET_BANKING") // Exemplo de header comum em sistemas financeiros
                .build();
    }
}