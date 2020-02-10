package com.northwind.catalogservice.API;

import com.northwind.catalogservice.Domain.CatalogCategory;
import com.northwind.catalogservice.Helper.CatalogCategoryMapper;
import com.northwind.catalogservice.Service.CatalogCategoryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogCategory")
public class CatalogCategoryController {

    private CatalogCategoryService service;

    Log logger = LogFactory.getLog(CatalogCategoryController.class);

    @Autowired
    public CatalogCategoryController(CatalogCategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<CatalogCategoryModel> getCategoryById(@RequestParam long categoryId){
        try {
            CatalogCategory model = service.getByCategoryId(categoryId);
            return ResponseEntity.ok().body(CatalogCategoryMapper.toModel(model));
        }catch (Exception e){
            logger.error("Exception while fetching all the Categories",e);
            return null;
        }
    }

    @GetMapping("/getAllCategories")
    public ResponseEntity<List<CatalogCategoryModel>> getAllCategories(){
        try {
            List<CatalogCategoryModel> model = service.getAllCategories().stream().filter(c -> Objects.nonNull(c))
                    .map(c -> CatalogCategoryMapper.toModel(c)).collect(Collectors.toList());
            return ResponseEntity.ok(model);
        }catch (Exception e){
            logger.error("Exception in /getAllCategories",e);
            return null;
        }
    }

    @PostMapping("/saveCategory")
    public ResponseEntity<CatalogCategoryModel> saveCategory(@RequestBody CatalogCategoryModel catalogCategoryModel){
        try {
            CatalogCategory catalogCategory = CatalogCategoryMapper.toObject(catalogCategoryModel);
            CatalogCategoryModel categoryModel = CatalogCategoryMapper.toModel(service.saveCategory(catalogCategory));
            return ResponseEntity.ok().body(categoryModel);
        }catch (Exception e){
            logger.error("Exception in /saveCategory",e);
            return null;
        }
    }

    @PutMapping("/updateCategory")
    public ResponseEntity<CatalogCategoryModel> updateCategory(@RequestBody CatalogCategoryModel catalogCategoryModel){
        CatalogCategory category = service.getByCategoryId(catalogCategoryModel.getId());
        if(Objects.isNull(category) || Objects.isNull(getCategoryById(category.getId())))
            return ResponseEntity.notFound().build();

        CatalogCategoryModel categoryModel = CatalogCategoryMapper.toModel(service.saveCategory(CatalogCategoryMapper.update(catalogCategoryModel, category )));
        return ResponseEntity.ok().body(categoryModel);
    }

    @DeleteMapping(path = "/{categoryId}")
    public ResponseEntity deleteCategory(@PathVariable long categoryId){
        CatalogCategory category = service.getByCategoryId(categoryId);
        if(Objects.isNull(category) && Objects.isNull(getCategoryById(category.getId())))
            return ResponseEntity.notFound().build();
        else{
            service.deleteCategoryId(categoryId);
            return ResponseEntity.ok().build();
        }
    }
}
