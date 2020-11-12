package co.com.bancolombia.usecase.operacionesproductos;

import co.com.bancolombia.model.category.Category;
import co.com.bancolombia.model.product.Product;
import co.com.bancolombia.model.product.gateways.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class OperacionesProductosUseCase {
    private final ProductRepository iProductRepository;

    public List<Product> listAllProduct(Long categoryId){
        List<Product> products = new ArrayList<>();
        if (null ==  categoryId){
            products = iProductRepository.listAllProduct();
        }
        return products;
    }

    public Product getProduct(Long id) {
        Product product =  iProductRepository.getProduct(id);
        return product;
    }

    public Product createProduct(Product product) {
        Product productCreate =  iProductRepository.createProduct(product);
        return productCreate;
    }

    public Product updateProduct(Product product) {
        Product productUpdate = iProductRepository.updateProduct(product);
        return productUpdate;
    }

    public  Product deleteProduct(Long id) {
        Product productDelete = iProductRepository.deleteProduct(id);
        return productDelete;
    }

    public List<Product> findByCategory(Category category) {
        List<Product> productCategory = iProductRepository.findByCategory(category);
        return productCategory;
    }
}
