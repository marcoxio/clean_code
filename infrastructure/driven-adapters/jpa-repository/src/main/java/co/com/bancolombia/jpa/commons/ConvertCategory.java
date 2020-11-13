package co.com.bancolombia.jpa.commons;

import co.com.bancolombia.jpa.entity.EntityCategory;
import co.com.bancolombia.model.category.Category;

public class ConvertCategory {
    public static Category entityToModel(EntityCategory entityCategory) {
        return Category.builder()
                .id(entityCategory.getId())
                .name(entityCategory.getName())
                .build();
    }

    public static EntityCategory modelToEntity(Category category) {
        return EntityCategory.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
