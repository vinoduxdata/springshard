package in.uxdata.springpostgres.controller;

import in.uxdata.springpostgres.model.Order;
import in.uxdata.springpostgres.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // GET /orders/{id} → Fetch order by ID
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        Optional<Order> order = orderService.getOrderById(id);
        return order.orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
    }

    // POST /orders → Create new order
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    // POST /orders/batch → Get multiple orders by IDs
    @PostMapping("/batch")
    public List<Order> getOrdersByIds(@RequestBody List<Long> orderIds) {
        return orderService.getOrdersByIds(orderIds);
    }
}
