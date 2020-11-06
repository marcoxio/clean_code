package co.com.bancolombia.jpa.entity;

import co.com.bancolombia.model.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntityCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public static Category entityToModel(EntityCategory entityCategory) {
        return Category.builder()
                .id(entityCategory.getId())
                .name(entityCategory.getName())
                .build();
    }
}
