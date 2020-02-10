package com.northwind.catalogservice.Service;

import com.northwind.catalogservice.Domain.Product;
import com.northwind.catalogservice.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(long productId){ return productRepository.findById(productId); }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
}
