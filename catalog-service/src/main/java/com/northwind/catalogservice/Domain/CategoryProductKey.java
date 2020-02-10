package com.northwind.catalogservice.Domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class CategoryProductKey implements Serializable {

    @Column(name = "ProductID")
    private long productId;

    @Column(name = "CategoryID")
    private long categoryId;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public CategoryProductKey(){}
    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
