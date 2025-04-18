package in.uxdata.springpostgres.dao;

import in.uxdata.springpostgres.model.Order;
import java.util.List;

public interface OrderDao {
    Order getOrderById(Long id);
    List<Order> getAllOrders();
    Order saveOrder(Order order);
}
