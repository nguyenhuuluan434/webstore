package com.lsa.webstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lsa.webstore.domain.Product;
import com.lsa.webstore.domain.repository.ProductRepository;

@Service
public class ProductRepositoryImpl implements ProductRepository {

	private static List<Product> listOfProducts = new ArrayList<Product>();
	private String name;

	public void getName() {
		 System.out.println(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductRepositoryImpl() {
		Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
		iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
		iphone.setCategory("Smart Phone");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(1000);

		Product laptop_dell = new Product("P1235", "Dell Inspiron", new BigDecimal(700));
		laptop_dell.setDescription("Dell Inspiron 14-inch Laptop(Black) with 3rd Generation Intel Core processors");
		laptop_dell.setCategory("Laptop");
		laptop_dell.setManufacturer("Dell");
		laptop_dell.setUnitsInStock(1000);

		Product tablet_Nexus = new Product("P1236", "Nexus 7", new BigDecimal(300));
		tablet_Nexus.setDescription(
				"Google Nexus 7 is the lightest7 inch tablet With a quad-core Qualcomm Snapdragon™ S4 Proprocessor");
		tablet_Nexus.setCategory("Tablet");
		tablet_Nexus.setManufacturer("Google");
		tablet_Nexus.setUnitsInStock(1000);

		listOfProducts.add(iphone);
		listOfProducts.add(laptop_dell);
		listOfProducts.add(tablet_Nexus);
		this.name = "test get name";
	}

	@Override
	public List<Product> getAllProduct() {
		return listOfProducts;
	}

}
