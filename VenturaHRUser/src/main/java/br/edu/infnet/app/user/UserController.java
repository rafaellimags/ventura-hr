package br.edu.infnet.app.user;

import br.edu.infnet.domain.user.User;
import br.edu.infnet.infra.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Sinaliza que o componente é um controller REST
@RestController
// basepath
@RequestMapping(value = "/user")
//@RequestMapping({"/user"})
public class UserController {
    @Autowired
    private UserRepository repository;
     @GetMapping(value = "/email/{email}")
//    @GetMapping(path = {"/email/{email}"})
    public ResponseEntity getUserbyEmail(@PathVariable String email) {
        ResponseEntity ret = ResponseEntity.notFound().build();
        User user = this.repository.getByEmail(email);
        
        if(user != null) {
            ret = ResponseEntity.ok().body(user);
        }
        
        return ret;
    }
    
    @PostMapping
    public ResponseEntity createAccount(@RequestBody User user) {
        ResponseEntity ret = ResponseEntity.badRequest().build();
        
        // Inserir validações. faz parte do controller.
        
        User newUser = this.repository.insert(user);
        
        if(newUser != null) {
            ret = ResponseEntity.ok().body(newUser);
        }
        
        return ret;
    }
    
}
