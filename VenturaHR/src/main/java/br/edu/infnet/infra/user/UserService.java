package br.edu.infnet.infra.user;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

public class UserService {
    private final String REST_URI = "http://localhost:8081/user";
    private final Client client = ClientBuilder.newClient();
}
