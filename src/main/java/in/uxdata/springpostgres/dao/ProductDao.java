package in.uxdata.springpostgres.dao;

import in.uxdata.springpostgres.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    void delete(Long id);
}
