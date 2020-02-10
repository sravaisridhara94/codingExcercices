package com.northwind.catalogservice.Repository;

import com.northwind.catalogservice.Domain.CatalogCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogCatergoryRepository extends JpaRepository<CatalogCategory, Long> {

    CatalogCategory findById(long categoryId);

}
