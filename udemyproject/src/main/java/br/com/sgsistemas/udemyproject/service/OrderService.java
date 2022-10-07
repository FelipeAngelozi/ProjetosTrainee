package br.com.sgsistemas.udemyproject.service;

import br.com.sgsistemas.udemyproject.model.Order;
import br.com.sgsistemas.udemyproject.model.User;
import br.com.sgsistemas.udemyproject.repository.OrderRepository;
import br.com.sgsistemas.udemyproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> listar() {
        return orderRepository.findAll();
    }

    public Order listarID(Integer id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.get();
    }
}
