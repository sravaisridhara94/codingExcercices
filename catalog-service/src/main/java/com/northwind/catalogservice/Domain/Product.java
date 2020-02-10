package com.northwind.catalogservice.Domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Products")
public class Product {

    @EmbeddedId
    private CategoryProductKey id;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "QuantityPerUnit")
    private String quantityPerUnit;

    @Column(name = "ListPrice")
    private BigDecimal listPrice;

    @Column(name = "Published")
    private boolean published;

    @Column(name = "Version")
    private long version;

    @Column(name = "ObjectID", length = 36)
    private UUID ObjectId;

    @ManyToOne
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID",insertable = false, updatable = false)
    private CatalogCategory catalogCategory;

    public Product(){}

    public Product(CatalogCategory categoryCategory, long productId){
        this.catalogCategory = catalogCategory;
        this.id.setCategoryId(categoryCategory.getId());
        this.id.setProductId(productId);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public UUID getObjectId() {
        return ObjectId;
    }

    public void setObjectId(UUID objectId) {
        ObjectId = objectId;
    }

    public CategoryProductKey getId() {
        return id;
    }

    public void setId(CategoryProductKey id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return ObjectId.equals(product.ObjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ObjectId);
    }

}
