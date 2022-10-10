package br.com.sgsistemas.udemyproject.config;

import br.com.sgsistemas.udemyproject.model.*;
import br.com.sgsistemas.udemyproject.model.enums.OrderStatus;
import br.com.sgsistemas.udemyproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {


    }

    public void inserirCategory() {
        Category category1 = new Category(null, "Eletronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
    }

    public void inserirProduct(Category category1, Category category2, Category category3) {

        Product p1 = new Product(null,"The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null,"Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null,"PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null,"Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        addCategoryInProduct(category1,category2,category3,p1,p2,p3,p4,p5);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }

    public void addCategoryInProduct(Category category1, Category category2, Category category3, Product p1,Product p2, Product p3, Product p4,Product p5) {
        p1.getCategorySet().add(category2);
        p2.getCategorySet().add(category1);
        p3.getCategorySet().add(category3);
        p4.getCategorySet().add(category3);
        p5.getCategorySet().add(category3);
    }

    public void insertUser() {
        User user1 = new User(null,  "Maria Brown", "maria@gmail.com", "9999-9999", "1234" );
        User user2 = new User(null,  "ALex Green", "alex@gmail.com", "8888-8888", "4321" );

        userRepository.saveAll(Arrays.asList(user1, user2));
    }

    public void insertOrder(User user1, User user2) {

        Order order1 = new Order(null, Instant.now(), user1, OrderStatus.WAITING_PAYMENT);
        Order order2 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), user2, OrderStatus.PAID);
        Order order3 = new Order(null, Instant.parse("2020-11-21T03:33:32Z"), user1, OrderStatus.SHIPPED);

        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }

//    public void insertOrderItem() {
//        OrderItem oi1 = new OrderItem(order1, p1, 2, p1.getPrice());
//        OrderItem oi2 = new OrderItem(order1, p3, 1, p3.getPrice());
//        OrderItem oi3 = new OrderItem(order2, p3, 2, p3.getPrice());
//        OrderItem oi4 = new OrderItem(order3, p5, 2, p5.getPrice());
//
//        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
//    }

    public void insertPaymentInOrder() {
        Order order = orderRepository.findById(1).get();
        Payment payment = new Payment(null, Instant.now(), order);
        order.setPayment(payment);
        orderRepository.save(order);
    }
}
