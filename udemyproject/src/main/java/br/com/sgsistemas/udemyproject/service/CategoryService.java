package br.com.sgsistemas.udemyproject.service;

import br.com.sgsistemas.udemyproject.model.Category;
import br.com.sgsistemas.udemyproject.model.Order;
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

    public void deletar(Integer id) {
        categoryRepository.deleteById(id);
    }

    public Category gravar(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Integer id, Category category) {
        Category category1 = categoryRepository.getReferenceById(id);
        updateData(category1, category);
        return  categoryRepository.save(category1);

    }
    private void updateData(Category category1, Category category) {
        category1.setName(category.getName());
    }
}