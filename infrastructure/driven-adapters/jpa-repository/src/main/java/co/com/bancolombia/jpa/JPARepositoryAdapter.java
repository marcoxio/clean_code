package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.entity.EntityProduct;
import co.com.bancolombia.model.category.Category;
import co.com.bancolombia.model.product.Product;
import co.com.bancolombia.model.product.gateways.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JPARepositoryAdapter implements ProductRepository
// implements ModelRepository from domain
{
    private final JPARepository iJPARepository;



    @Override
    public List<Product> listAllProduct() {
       List<EntityProduct> entityProductList = (List<EntityProduct>) iJPARepository.findAll();
       return EntityProduct.entityToModelList(entityProductList);
    }

    @Override
    public Product getProduct(Long id) {
        EntityProduct entityProductList = (EntityProduct) iJPARepository.findById(id).orElse(null);
        return EntityProduct.entityToModel(entityProductList);
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long id) {
        return null;
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return null;
    }

    @Override
    public Product updateStock(Long id, Double quantity) {
        return null;
    }
}
