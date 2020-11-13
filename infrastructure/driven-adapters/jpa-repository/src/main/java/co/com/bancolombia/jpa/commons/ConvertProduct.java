package co.com.bancolombia.jpa.commons;


import co.com.bancolombia.jpa.entity.EntityProduct;
import co.com.bancolombia.model.product.Product;


import java.util.List;
import java.util.stream.Collectors;

public class ConvertProduct {

    public static Product entityToModel(EntityProduct entityProduct) {
        return Product.builder()
                .id(entityProduct.getId())
                .name(entityProduct.getName())
                .description(entityProduct.getDescription())
                .stock(entityProduct.getStock())
                .price(entityProduct.getPrice())
                .status(entityProduct.getStatus())
                .createAt(entityProduct.getCreateAt())
                .category(ConvertCategory.entityToModel(entityProduct.getCategory()))
                //.category(entityProduct.getCategory().entityToModel(entityProduct.getCategory()))
                .build();
    }

    public static EntityProduct modelToEntity(Product product) {
        return  EntityProduct.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .stock(product.getStock())
                .price(product.getPrice())
                .status(product.getStatus())
                .createAt(product.getCreateAt())
                .category(ConvertCategory.modelToEntity(product.getCategory()))
                //.category(EntityCategory.modelToEntity(product.getCategory()))
                .build();
    }

    public static List<Product> entityToModelList(List<EntityProduct> entityProductList) {
        return entityProductList.stream()
                .map(entityProduct -> ConvertProduct.entityToModel(entityProduct))
                //.map(entityProduct -> entityProduct.entityToModel(entityProduct))
                .collect(Collectors.toList());

    }


}
