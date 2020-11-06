package co.com.bancolombia.config;

import co.com.bancolombia.model.product.gateways.ProductRepository;
import co.com.bancolombia.usecase.operacionesproductos.OperacionesProductosUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OperacionesProductoConfig {

    @Bean
    public OperacionesProductosUseCase config(ProductRepository productRepository) {
        return new OperacionesProductosUseCase(productRepository);
    }
}
