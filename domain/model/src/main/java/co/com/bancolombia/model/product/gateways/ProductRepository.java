package co.com.bancolombia.model.product.gateways;

import co.com.bancolombia.model.category.Category;
import co.com.bancolombia.model.product.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> listAllProduct();
    public Product getProduct(Long id);

    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public Product deleteProduct(Long id);
    public List<Product> findByCategory(Category category);
    public Product updateStock(Long id, Double quantity);

}
