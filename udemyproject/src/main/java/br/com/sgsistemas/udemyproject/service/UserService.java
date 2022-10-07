package br.com.sgsistemas.udemyproject.service;


import br.com.sgsistemas.udemyproject.model.User;
import br.com.sgsistemas.udemyproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> listar() {
        return userRepository.findAll();
    }

    public User listarID(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public User gravar(User user) {
        return userRepository.save(user);
    }

    public void deletar(Integer id) {
        userRepository.deleteById(id);
    }

    public User update(Integer id, User obj) {
        User entity = userRepository.getReferenceById(id);
        updateData(entity, obj);
        return  userRepository.save(entity);

    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
