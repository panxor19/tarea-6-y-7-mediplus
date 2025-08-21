package com.mediplus.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import com.mediplus.mock.MockServidor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class CitasTest {
    static String token = "token_valido_simulado";

    @BeforeAll
    static void configurar() {
    MockServidor.iniciar();
    RestAssured.baseURI = "http://localhost:8089";
    }

    @Test
    void obtenerListaCitas() {
        given()
            .header("Authorization", "Bearer " + token)
        .when()
            .get("/citas")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("size()", greaterThanOrEqualTo(0))
            .time(lessThan(3000L));
    }

    @Test
    void agendarCita() {
    String nuevaCita = "{\"pacienteId\":1}";
        given()
            .header("Authorization", "Bearer " + token)
            .contentType(ContentType.JSON)
            .body(nuevaCita)
        .when()
            .post("/citas")
        .then()
            .statusCode(201)
            .body("pacienteId", equalTo(1))
            .time(lessThan(3000L));
    }

    @Test
    void eliminarCitaNoExistente() {
        given()
            .header("Authorization", "Bearer " + token)
        .when()
            .delete("/citas/99999")
        .then()
            .statusCode(404)
            .body("mensaje", containsString("no encontrada"));
    }
}
