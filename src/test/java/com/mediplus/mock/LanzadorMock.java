package com.mediplus.mock;

public class LanzadorMock {
    public static void main(String[] args) {
        System.out.println("Iniciando MockServidor...");
        MockServidor.iniciar();
        System.out.println("Servidor WireMock iniciado en http://localhost:8089");
        System.out.println("Presione Ctrl+C para detener.");
        // Mantener el servidor corriendo
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
