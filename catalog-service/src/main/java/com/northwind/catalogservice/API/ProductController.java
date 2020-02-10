package com.northwind.catalogservice.API;

import com.northwind.catalogservice.Domain.Product;
import com.northwind.catalogservice.Helper.ProductMapper;
import com.northwind.catalogservice.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productController")
public class ProductController {

    private CatalogCategoryController catalogCategoryController;

    private ProductService productService;

    @Autowired
    public ProductController(CatalogCategoryController catalogCategoryController, ProductService productService) {
        this.catalogCategoryController = catalogCategoryController;
        this.productService = productService;
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        List<ProductModel> productModels = productService.getAllProducts().stream().filter(Objects::nonNull)
                            .map(c -> ProductMapper.toModel(c)).collect(Collectors.toList());
        return ResponseEntity.ok(productModels);
    }

    @GetMapping(path = "/{productId}")
    public ResponseEntity<ProductModel> getByProductId(@PathVariable long productId){
        ProductModel productModel = ProductMapper.toModel(productService.getProductById(productId));
        return ResponseEntity.ok(productModel);
    }

//    @PostMapping("/saveProduct")
//    public ResponseEntity<ProductModel> saveProduct(@RequestBody ProductModel model){
//        Product product = ProductMapper.toObject(model);
//
//        if(Objects.nonNull(product) && Objects.nonNull(catalogCategoryController.getCategoryById(product.getCategoryId()))){
//            ProductModel productModel = ProductMapper.toModel(productService.saveProduct(product));
//            return ResponseEntity.ok().body(productModel);
//        }
//        return ResponseEntity.notFound().build();
//
//    }
}
