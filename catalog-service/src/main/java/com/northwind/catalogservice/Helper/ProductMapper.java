package com.northwind.catalogservice.Helper;

import com.northwind.catalogservice.API.ProductModel;
import com.northwind.catalogservice.Domain.Product;

public class ProductMapper {

    public static ProductModel toModel(Product product){
        ProductModel model = new ProductModel();
        //model.setCategoryId(product.getId().getCategoryId());
        model.setListPrice(product.getListPrice());
        //model.setProductId(product.getId().getProductId());
        model.setPublished(product.isPublished());
        model.setQuantityPerUnit(product.getQuantityPerUnit());
        model.setVersion(product.getVersion());
        model.setProductName(product.getProductName());
        return model;
    }


}
