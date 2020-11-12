package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.entity.EntityCategory;
import co.com.bancolombia.jpa.entity.EntityProduct;
import co.com.bancolombia.model.category.Category;
import co.com.bancolombia.model.product.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface JPARepository extends CrudRepository<EntityProduct, Long> {
    public List<EntityProduct> findByCategory(EntityCategory category);
}
