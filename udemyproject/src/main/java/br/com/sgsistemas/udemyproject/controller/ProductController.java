package br.com.sgsistemas.udemyproject.controller;


import br.com.sgsistemas.udemyproject.model.Order;
import br.com.sgsistemas.udemyproject.model.Product;
import br.com.sgsistemas.udemyproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productService.listar();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findPerID(@PathVariable Integer id) {
        Product product = productService.listarID(id);
        return ResponseEntity.ok().body(product);
    }
}
