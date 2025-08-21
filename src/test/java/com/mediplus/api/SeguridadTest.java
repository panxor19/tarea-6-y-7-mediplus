package com.mediplus.api;

import io.restassured.RestAssured;
import com.mediplus.mock.MockServidor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class SeguridadTest {
    static String tokenValido = "token_valido_simulado";
    static String tokenInvalido = "token_invalido_simulado";

    @BeforeAll
    static void configurar() {
    MockServidor.iniciar();
    RestAssured.baseURI = "http://localhost:8089";
    }

    @Test
    void accesoConTokenValido() {
        given()
            .header("Authorization", "Bearer " + tokenValido)
        .when()
            .get("/pacientes")
        .then()
            .statusCode(200)
            .body("size()", greaterThan(0));
    }

    @Test
    void accesoConTokenInvalido() {
        given()
            .header("Authorization", "Bearer " + tokenInvalido)
        .when()
            .get("/pacientes")
        .then()
            .statusCode(401)
            .body("mensaje", containsString("no autorizado"));
    }

    @Test
    void postConTokenValido() {
    String nuevoPaciente = "{\"nombre\":\"Luis\"}";
        given()
            .header("Authorization", "Bearer " + tokenValido)
            .contentType("application/json")
            .body(nuevoPaciente)
        .when()
            .post("/pacientes")
        .then()
            .statusCode(201)
            .body("nombre", equalTo("Luis"));
    }

    @Test
    void postConTokenInvalido() {
        // Simulación: endpoint de creación con token inválido (reqres ignora token, validamos eco de datos)
    String nuevoPaciente = "{\"nombre\":\"Luis\"}";
        given()
            .header("Authorization", "Bearer " + tokenInvalido)
            .contentType("application/json")
            .body(nuevoPaciente)
        .when()
            .post("/pacientes")
        .then()
            .statusCode(401)
            .body("mensaje", containsString("no autorizado"));
    }
}
