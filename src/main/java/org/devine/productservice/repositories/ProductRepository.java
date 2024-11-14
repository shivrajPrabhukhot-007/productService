package org.devine.productservice.repositories;

import org.devine.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>{
    public Product save(Product product);

    public List<Product> findAll();

    Optional<Product> findById(Long id);
}