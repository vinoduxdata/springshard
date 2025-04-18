package in.uxdata.springpostgres.service;

import in.uxdata.springpostgres.config.ShardRoutingDataSource;
import in.uxdata.springpostgres.model.Order;
import in.uxdata.springpostgres.repository.OrderRepository;
import in.uxdata.springpostgres.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        String shardKey = resolveShard(order.getOrderId());
        try {
            ShardRoutingDataSource.setCurrentShard(shardKey);
            return orderRepository.save(order);
        } finally {
            ShardRoutingDataSource.clear();
        }
    }

    @Override
    public Optional<Order> getOrderById(Long orderId) {
        String shardKey = resolveShard(orderId);
        try {
            ShardRoutingDataSource.setCurrentShard(shardKey);
            return orderRepository.findById(orderId);
        } finally {
            ShardRoutingDataSource.clear();
        }
    }

    @Override
    public List<Order> getOrdersByIds(List<Long> orderIds) {
        List<Order> results = new ArrayList<>();
        List<Long> shard1Ids = new ArrayList<>();
        List<Long> shard2Ids = new ArrayList<>();

        for (Long id : orderIds) {
            if (id >= 1 && id <= 9) {
                shard1Ids.add(id);
            } else {
                shard2Ids.add(id);
            }
        }

        try {
            if (!shard1Ids.isEmpty()) {
                ShardRoutingDataSource.setCurrentShard("shard1");
                results.addAll(orderRepository.findAllById(shard1Ids));
            }
            if (!shard2Ids.isEmpty()) {
                ShardRoutingDataSource.setCurrentShard("shard2");
                results.addAll(orderRepository.findAllById(shard2Ids));
            }
        } finally {
            ShardRoutingDataSource.clear();
        }

        return results;
    }

    private String resolveShard(Long orderId) {
        if (orderId == null) {
            throw new IllegalArgumentException("orderId cannot be null for shard routing.");
        }
        return (orderId >= 1 && orderId <= 9) ? "shard1" : "shard2";
    }
}
