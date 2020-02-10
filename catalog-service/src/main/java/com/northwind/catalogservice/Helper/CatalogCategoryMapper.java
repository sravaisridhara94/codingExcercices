package com.northwind.catalogservice.Helper;

import com.northwind.catalogservice.API.CatalogCategoryModel;
import com.northwind.catalogservice.Domain.CatalogCategory;

import java.util.Objects;
import java.util.UUID;

public class CatalogCategoryMapper {

    public static CatalogCategory toObject(CatalogCategoryModel model){
        CatalogCategory catalogCategory = new CatalogCategory();
        catalogCategory.setCategoryName(model.getCategoryName());
        catalogCategory.setDescription(model.getDescription());
        catalogCategory.setId(model.getId());
//        catalogCategory.setPicture(model.getPicture());
        catalogCategory.setVersion(model.getVersion());
        catalogCategory.setProductsList(model.getProductsList());
        return catalogCategory;
    }

    public static CatalogCategoryModel toModel(CatalogCategory catalogCategory){
        CatalogCategoryModel categoryModel = new CatalogCategoryModel();
        categoryModel.setCategoryName(catalogCategory.getCategoryName());
        categoryModel.setDescription(catalogCategory.getDescription());
        categoryModel.setId(catalogCategory.getId());
//        categoryModel.setPicture(catalogCategory.getPicture());
        categoryModel.setVersion(catalogCategory.getVersion());
        categoryModel.setProductsList(catalogCategory.getProductsList());
        return categoryModel;
    }

    public static CatalogCategory update(CatalogCategoryModel catalogCategoryModel, CatalogCategory catalogCategory){
        CatalogCategory category = new CatalogCategory();
        category.setId(catalogCategoryModel.getId());
        category.setVersion(catalogCategory.getVersion()+1);
        category.setDescription(catalogCategoryModel.getDescription());
        category.setCategoryName(catalogCategoryModel.getCategoryName());
        return category;
    }
}
