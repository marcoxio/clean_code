package co.com.bancolombia.api;

import co.com.bancolombia.model.product.Product;
import co.com.bancolombia.usecase.operacionesproductos.OperacionesProductosUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final OperacionesProductosUseCase operacionesProductosUseCase;

    @GetMapping(path = "/hello")
    public String health() {
//        return useCase.doAction();
        return "HelloWorld";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> listProduct(@RequestParam(name = "categoryId", required = false) Long categoryId){
        return ResponseEntity.ok(operacionesProductosUseCase.listAllProduct(categoryId));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> productById(@PathVariable Long id){
        return ResponseEntity.ok(operacionesProductosUseCase.getProduct(id));
    }

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product, BindingResult result) {
        return ResponseEntity.ok(operacionesProductosUseCase.createProduct(product));
    }
}
