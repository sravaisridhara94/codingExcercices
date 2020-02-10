package com.northwind.catalogservice.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Categories")
public class CatalogCategory  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private long id;

    @Column(name = "CategoryName")
    private String categoryName;
    @Column(name = "Description")
    private String description;

    //    @Column(name = "Picture")
    //    private Object picture;

    @Column(name = "Version")
    private long version;
    @Column(name = "ObjectID", length = 36)
    private UUID ObjectId;

    @OneToMany(mappedBy = "catalogCategory", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Product> productsList = new ArrayList<>();

    public CatalogCategory(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Object getPicture() {
//        return picture;
//    }
//
//    public void setPicture(Object picture) {
//        this.picture = picture;
//    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    public UUID getObjectId() {
        return ObjectId;
    }

    public void setObjectId(UUID objectId) {
        ObjectId = objectId;
    }

    @Override
    public int hashCode() {
        return ObjectId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Product))
            return false;

        Product other = (Product)obj;
        return this.ObjectId.equals(other);
    }

    public void addProduct(Product product){
        product.getId().setCategoryId(this.id);
        productsList.add(product);
    }

    public void removeProduct (Product product) {
        productsList.remove(product);
    }
}


