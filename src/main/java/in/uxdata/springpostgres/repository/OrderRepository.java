package in.uxdata.springpostgres.repository;

import in.uxdata.springpostgres.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
