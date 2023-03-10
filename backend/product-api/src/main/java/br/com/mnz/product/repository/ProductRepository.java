package br.com.mnz.product.repository;

import br.com.mnz.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {
}
