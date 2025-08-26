package com.mediplus.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import com.mediplus.mock.MockServidor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class MedicosTest {
    static String token = "token_valido_simulado";

    @BeforeAll
    static void configurar() {
        MockServidor.iniciar();
        RestAssured.baseURI = "http://localhost:8089";
    }

    @Test
    void actualizarMedico() {
        String datosMedico = "{\"nombre\":\"Dr Juan Perez\",\"especialidad\":\"Cardiologia\"}";
        given()
            .header("Authorization", "Bearer " + token)
            .contentType(ContentType.JSON)
            .body(datosMedico)
        .when()
            .put("/medicos/2")
        .then()
            .statusCode(200)
            .body("especialidad", equalTo("Cardiología"))
            .time(lessThan(3000L));
    }
}
