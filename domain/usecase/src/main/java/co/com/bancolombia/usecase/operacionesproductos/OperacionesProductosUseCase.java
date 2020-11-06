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
}
