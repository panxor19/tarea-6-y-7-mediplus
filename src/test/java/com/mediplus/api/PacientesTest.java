package com.mediplus.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import com.mediplus.mock.MockServidor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class PacientesTest {
    static String token = "token_valido_simulado";

    @BeforeAll
    static void configurar() {
        MockServidor.iniciar();
        RestAssured.baseURI = "http://localhost:8089";
    }

    @Test
    void obtenerListaPacientes() {
        given()
            .header("Authorization", "Bearer " + token)
        .when()
            .get("/pacientes")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("size()", greaterThan(0))
            .time(lessThan(3000L));
    }

    @Test
    void registrarPaciente() {
    String nuevoPaciente = "{\"nombre\":\"Ana\"}";
        given()
            .header("Authorization", "Bearer " + token)
            .contentType(ContentType.JSON)
            .body(nuevoPaciente)
        .when()
            .post("/pacientes")
        .then()
            .statusCode(201)
            .body("nombre", equalTo("Ana"))
            .time(lessThan(3000L));
    }

    @Test
    void registrarPacienteDatosInvalidos() {
        String registroIncompleto = "{ }"; // falta nombre y sin token -> no autorizado
        given()
            .contentType(ContentType.JSON)
            .body(registroIncompleto)
        .when()
            .post("/pacientes")
        .then()
            .statusCode(401)
            .body("mensaje", containsString("no autorizado"));
    }
}
