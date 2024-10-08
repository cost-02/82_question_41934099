package com.example;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;

public class SSLCipherSuiteTest {

    public static void main(String[] args) {
        // Specifica l'host e la porta del server con cui testare la connessione
        String host = "your.server.com";
        int port = 443;

        // Specifica le suite di cifrature che vuoi testare
        String[] enabledCipherSuites = {"TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384"};

        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try (SSLSocket socket = (SSLSocket) factory.createSocket(host, port)) {
            // Imposta le suite di cifrature da utilizzare
            socket.setEnabledCipherSuites(enabledCipherSuites);

            // Avvia l'handshake SSL per testare la connessione
            socket.startHandshake();

            System.out.println("Connessione riuscita usando la suite di cifrature specificata.");
        } catch (IOException e) {
            System.out.println("Errore di connessione: " + e.getMessage());
        }
    }
}
