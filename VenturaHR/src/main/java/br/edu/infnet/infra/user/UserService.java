package br.edu.infnet.infra.user;

import br.edu.infnet.domain.user.User;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;

public class UserService {
    private final String REST_URI = "http://localhost:8081/user"; // basepath
    private final Client client = ClientBuilder.newClient();
    
    public User getByEmail(String email) {
        
        return client.target(REST_URI)
                     .path("email")
                     .path(email)
                     .request(MediaType.APPLICATION_JSON)
                     .get(User.class);
    }
    
    public User createAccount(User user) {
        return client.target(REST_URI)
                     .path("user")
                     .request(MediaType.APPLICATION_JSON)
                     // cria uma entity do objeto para mandar como um json, dizendo 
                     // que ele´pertence a classe user.
                     // User.class transforma o objeto em umna classe quando o pega
                     // da requisição
                     .post(Entity.entity(user, MediaType.APPLICATION_JSON), User.class);
    }
}
