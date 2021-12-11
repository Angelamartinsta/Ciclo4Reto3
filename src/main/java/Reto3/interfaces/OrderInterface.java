package Reto3.interfaces;

import Reto3.modelo.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderInterface extends MongoRepository<Order, Integer> {
    List<Order> findBySalesManZone(String zone);
}
