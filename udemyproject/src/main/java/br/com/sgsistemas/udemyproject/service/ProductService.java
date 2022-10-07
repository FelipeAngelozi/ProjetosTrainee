package br.com.sgsistemas.udemyproject.service;

import br.com.sgsistemas.udemyproject.model.Product;
import br.com.sgsistemas.udemyproject.model.User;
import br.com.sgsistemas.udemyproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> listar() {
        return productRepository.findAll();
    }

    public Product listarID(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }
}
