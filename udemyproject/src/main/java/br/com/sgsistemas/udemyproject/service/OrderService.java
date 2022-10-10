package br.com.sgsistemas.udemyproject.service;

import br.com.sgsistemas.udemyproject.model.Order;
import br.com.sgsistemas.udemyproject.model.User;
import br.com.sgsistemas.udemyproject.repository.OrderRepository;
import br.com.sgsistemas.udemyproject.repository.UserRepository;
import org.aspectj.weaver.ast.Or;
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

    public void deletar(Integer id) {
        orderRepository.deleteById(id);
    }

    public Order gravar(Order order) {
        return orderRepository.save(order);
    }
    public Order update(Integer id, Order order) {
        Order order1 = orderRepository.getReferenceById(id);
        updateData(order1, order);
        return  orderRepository.save(order1);

    }
    private void updateData(Order order, Order order1) {
        order1.setClient(order.getClient());
        order1.setOrderStatus(order.getOrderStatus());
        order1.setMoment(order.getMoment());

    }

}
