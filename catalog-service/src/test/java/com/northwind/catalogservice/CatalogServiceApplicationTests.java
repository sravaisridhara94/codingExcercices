package com.northwind.catalogservice;

import com.northwind.catalogservice.Domain.CatalogCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CatalogServiceApplicationTests {

	private String categoryName = new String(new char[50]).replace("/0","X");

	@Test
	void contextLoads() {
	}

	@Test
	public void validate_productName(){
		CatalogCategory category = new CatalogCategory();
		Assertions.assertEquals(categoryName, category.getCategoryName());
	}

}
