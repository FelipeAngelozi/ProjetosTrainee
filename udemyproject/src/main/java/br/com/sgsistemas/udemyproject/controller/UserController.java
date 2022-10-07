package br.com.sgsistemas.udemyproject.controller;

import br.com.sgsistemas.udemyproject.model.User;
import br.com.sgsistemas.udemyproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> user = userService.listar();
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findPerID(@PathVariable Integer id) {
        User user = userService.listarID(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = userService.gravar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User obj) {
        obj = userService.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }
}
