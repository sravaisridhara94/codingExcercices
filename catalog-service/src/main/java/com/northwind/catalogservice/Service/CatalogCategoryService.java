package com.northwind.catalogservice.Service;

import com.northwind.catalogservice.Domain.CatalogCategory;
import com.northwind.catalogservice.Repository.CatalogCatergoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogCategoryService {

    private CatalogCatergoryRepository repository;

    @Autowired
    public CatalogCategoryService(CatalogCatergoryRepository repository) {
        this.repository = repository;
    }

    public CatalogCategory getByCategoryId(long categoryId){
        return repository.findById(categoryId);
    }

    public List<CatalogCategory> getAllCategories(){
        return repository.findAll();
    }

    public CatalogCategory saveCategory(CatalogCategory catalogCategory){
        return repository.save(catalogCategory);
    }

    public void deleteCategoryId(long categoryId){
        repository.deleteById(categoryId);
    }

}
