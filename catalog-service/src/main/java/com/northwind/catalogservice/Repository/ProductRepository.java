package com.northwind.catalogservice.Repository;

import com.northwind.catalogservice.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public Product findById(long productId);
}
