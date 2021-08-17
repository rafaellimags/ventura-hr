package br.edu.infnet.infra.user;

import br.edu.infnet.domain.user.User;
import java.util.Collection;
import java.util.HashMap;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private HashMap<String, User> users;
    
    public UserRepository() {
        users = new HashMap<>();
        users.put("rafael@email.com", new User("Rafael Lima", "rafael@email.com", "034995425734"));
        users.put("wayne@enterprise.com", new User("Bruce Wayne", "wayne@enterprise.com", "554995340001"));
    }
    
    public User getByEmail(String email) {
        return users.get(email);
    }
    
    public Collection findAll() {
        return users.values();
    }
    
    public User insert(User user) {
        User ret = null;
        
        if(user.getEmail() != null && users.get(user.getEmail()) == null) {
            users.put(user. getEmail(), user);
            ret = user;
        }
        return ret;
    }
    
}
