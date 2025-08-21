package com.mediplus.mock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.Response;
import com.github.tomakehurst.wiremock.extension.ResponseTransformer;
import com.github.tomakehurst.wiremock.common.FileSource;

public class MockServidor {
    private static WireMockServer server;

    public static void iniciar() {
        if (server == null) {
            server = new WireMockServer(WireMockConfiguration.options().port(8089)
                    .extensions(new TransformerNombre()));
            server.start();
            WireMock.configureFor("localhost", 8089);
            stubEndpoints();
        }
    }

    private static void stubEndpoints() {
        // Autorizado GET pacientes
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/pacientes"))
                .withHeader("Authorization", WireMock.equalTo("Bearer token_valido_simulado"))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("[{\"id\":1,\"nombre\":\"Ana\"}]")
                ));
        // No autorizado GET pacientes
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/pacientes"))
                .atPriority(10)
                .willReturn(WireMock.aResponse().withStatus(401)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"mensaje\":\"no autorizado\"}")));
        // POST pacientes válido
        WireMock.stubFor(WireMock.post(WireMock.urlEqualTo("/pacientes"))
                .withHeader("Authorization", WireMock.equalTo("Bearer token_valido_simulado"))
                .withRequestBody(WireMock.matchingJsonPath("$.nombre", WireMock.matching(".+")))
                .willReturn(WireMock.aResponse().withStatus(201)
                        .withHeader("Content-Type", "application/json")
                        .withTransformers("respuesta-paciente")));
        // POST pacientes inválido
        WireMock.stubFor(WireMock.post(WireMock.urlEqualTo("/pacientes"))
                .withHeader("Authorization", WireMock.equalTo("Bearer token_valido_simulado"))
                .withRequestBody(WireMock.matchingJsonPath("$.nombre", WireMock.absent()))
                .willReturn(WireMock.aResponse().withStatus(400)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"mensaje\":\"datos inválidos\"}")));
        // POST pacientes no autorizado
        WireMock.stubFor(WireMock.post(WireMock.urlEqualTo("/pacientes"))
                .atPriority(10)
                .willReturn(WireMock.aResponse().withStatus(401)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"mensaje\":\"no autorizado\"}")));
        // GET citas
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/citas"))
                .willReturn(WireMock.aResponse().withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("[{\"id\":5,\"pacienteId\":1}]")));
        // POST citas
        WireMock.stubFor(WireMock.post(WireMock.urlEqualTo("/citas"))
                .willReturn(WireMock.aResponse().withStatus(201)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"id\":99,\"pacienteId\":1}")));
        // DELETE cita inexistente
        WireMock.stubFor(WireMock.delete(WireMock.urlEqualTo("/citas/99999"))
                .willReturn(WireMock.aResponse().withStatus(404)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"mensaje\":\"no encontrada\"}")));
        // PUT medico
        WireMock.stubFor(WireMock.put(WireMock.urlEqualTo("/medicos/2"))
                .willReturn(WireMock.aResponse().withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"id\":2,\"especialidad\":\"Cardiología\"}")));
    }
}
class TransformerNombre extends ResponseTransformer {
        @Override
                public Response transform(Request request, Response response, FileSource files, Parameters parameters) {
                String body = request.getBodyAsString();
                String nombre = "Ana";
                if (body != null && body.contains("\"nombre\"")) {
                        int idx = body.indexOf("\"nombre\"");
                        int colon = body.indexOf(':', idx);
                        int firstQuote = body.indexOf('"', colon+1);
                        int secondQuote = body.indexOf('"', firstQuote+1);
                        if (firstQuote>0 && secondQuote>firstQuote) nombre = body.substring(firstQuote+1, secondQuote);
                }
                String json = "{\"id\":10,\"nombre\":\""+nombre+"\"}";
                return Response.response().status(201).headers(response.getHeaders())
                                .body(json).build();
        }
        @Override public String getName() { return "respuesta-paciente"; }
        @Override public boolean applyGlobally() { return false; }
}
