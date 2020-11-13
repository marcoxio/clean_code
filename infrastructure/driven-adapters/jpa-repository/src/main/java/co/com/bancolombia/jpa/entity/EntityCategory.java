package co.com.bancolombia.jpa.entity;

import co.com.bancolombia.model.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
    @NotNull
    @NotEmpty(message = "El campo name Category no puede ir vacio")
    private String name;


}
