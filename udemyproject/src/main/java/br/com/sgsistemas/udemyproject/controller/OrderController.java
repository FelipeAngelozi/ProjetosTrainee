package br.com.sgsistemas.udemyproject.controller;

import br.com.sgsistemas.udemyproject.model.Order;
import br.com.sgsistemas.udemyproject.model.User;
import br.com.sgsistemas.udemyproject.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> order = orderService.listar();
        return ResponseEntity.ok().body(order);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findPerID(@PathVariable Integer id) {
        Order order = orderService.listarID(id);
        return ResponseEntity.ok().body(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        orderService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Order> insert(@RequestBody Order order) {
        order = orderService.gravar(order);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).body(order);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Order> update(@PathVariable Integer id, @RequestBody Order order){
        Order order1= orderService.update(id,order);
        return ResponseEntity.ok().body(order);
    }
}
