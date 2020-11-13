package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.commons.ConvertCategory;
import co.com.bancolombia.jpa.commons.ConvertProduct;
import co.com.bancolombia.jpa.entity.EntityProduct;
import co.com.bancolombia.model.category.Category;
import co.com.bancolombia.model.product.Product;
import co.com.bancolombia.model.product.gateways.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
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
       return ConvertProduct.entityToModelList(entityProductList);
    }



    @Override
    public Product getProduct(Long id) {
        EntityProduct entityProductList = (EntityProduct) iJPARepository.findById(id).orElse(null);
        return ConvertProduct.entityToModel(entityProductList);
    }

    @Override
    public Product createProduct(Product product) {
        product.setStatus("CREATED");
        product.setCreateAt(new Date());
        EntityProduct productCreate = (EntityProduct) iJPARepository.save(ConvertProduct.modelToEntity(product));
        return ConvertProduct.entityToModel(productCreate);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productDB = getProduct(product.getId());
        productDB.setName(product.getName());
        productDB.setDescription(product.getDescription());
        productDB.setCategory(product.getCategory());
        productDB.setPrice(product.getPrice());
        EntityProduct productUpdate = (EntityProduct) iJPARepository.save(ConvertProduct.modelToEntity(product));
        return ConvertProduct.entityToModel(productUpdate);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product productDB = getProduct(id);
        productDB.setStatus("DELETED");
        EntityProduct entityProductDelete = (EntityProduct) iJPARepository.findById(id).orElse(null);
        return ConvertProduct.entityToModel(entityProductDelete);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        List<EntityProduct> entityCategoryList = (List<EntityProduct>) iJPARepository.findByCategory(ConvertCategory.modelToEntity(category));
        return ConvertProduct.entityToModelList(entityCategoryList);
    }

    @Override
    public Product updateStock(Long id, Double quantity) {
        return null;
    }
}
