package in.uxdata.springpostgres.service;

import in.uxdata.springpostgres.dao.ProductDao;
import in.uxdata.springpostgres.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productDao.findById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productDao.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.delete(id);
    }
}
