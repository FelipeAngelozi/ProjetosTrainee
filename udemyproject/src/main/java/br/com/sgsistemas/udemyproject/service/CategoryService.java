package br.com.sgsistemas.udemyproject.service;

import br.com.sgsistemas.udemyproject.model.Category;
import br.com.sgsistemas.udemyproject.model.User;
import br.com.sgsistemas.udemyproject.repository.CategoryRepository;
import br.com.sgsistemas.udemyproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> listar() {
        return categoryRepository.findAll();
    }

    public Category listarID(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.get();
    }
}