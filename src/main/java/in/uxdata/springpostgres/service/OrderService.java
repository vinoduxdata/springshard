package in.uxdata.springpostgres.service;

import in.uxdata.springpostgres.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order saveOrder(Order order);
    Optional<Order> getOrderById(Long orderId);
    List<Order> getOrdersByIds(List<Long> orderIds);
}
