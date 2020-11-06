package co.com.bancolombia.jpa.entity;

import co.com.bancolombia.model.category.Category;
import co.com.bancolombia.model.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "tbl_products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntityProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre no debe ser vacío")
    private String name;
    private String description;
    @Positive(message = "El stock debe ser mayor que cero")
    private Double stock;
    private Double price;
    private String status;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @NotNull(message = "La categoria no puede ser vacia")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private EntityCategory category;

    public static Product entityToModel(EntityProduct entityProduct) {
        return Product.builder()
                .id(entityProduct.getId())
                .name(entityProduct.getName())
                .description(entityProduct.getDescription())
                .stock(entityProduct.getStock())
                .price(entityProduct.getPrice())
                .status(entityProduct.getStatus())
                .createAt(entityProduct.getCreateAt())
                .category(entityProduct.getCategory().entityToModel(entityProduct.getCategory()))
                .build();
    }


    public static List<Product> entityToModelList(List<EntityProduct> entityProductList) {
        return entityProductList.stream()
                .map(entityProduct -> entityProduct.entityToModel(entityProduct))
                .collect(Collectors.toList());

    }


}
