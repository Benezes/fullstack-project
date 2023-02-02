package br.com.mnz.product.service;

import br.com.mnz.product.dto.request.ProductRequest;
import br.com.mnz.product.dto.response.ProductResponse;
import br.com.mnz.product.entity.Product;
import br.com.mnz.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setValue(productRequest.getValue());
        product.setDesc(productRequest.getDesc());
        return new ProductResponse(productRepository.save(product));
    }

    @Transactional
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
