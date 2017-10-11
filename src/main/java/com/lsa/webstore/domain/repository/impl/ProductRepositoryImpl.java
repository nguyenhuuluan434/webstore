package com.lsa.webstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lsa.webstore.constant.Enum;
import com.lsa.webstore.domain.Product;
import com.lsa.webstore.domain.repository.ProductRepository;

//@Service
@Repository
public class ProductRepositoryImpl implements ProductRepository {

	private List<Product> listOfProducts = new ArrayList<Product>();
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
		iphone.setCategory(Enum.PHONE.getName());
		iphone.setManufacturer(Enum.APPLE.getName());
		iphone.setUnitsInStock(1000);

		Product laptop_dell = new Product("P1235", "Dell Inspiron", new BigDecimal(700));
		laptop_dell.setDescription("Dell Inspiron 14-inch Laptop(Black) with 3rd Generation Intel Core processors");
		laptop_dell.setCategory(Enum.LAPTOP.getName());
		laptop_dell.setManufacturer(Enum.DELL.getName());
		laptop_dell.setUnitsInStock(1000);

		Product tablet_Nexus = new Product("P1236", "Nexus 7", new BigDecimal(300));
		tablet_Nexus.setDescription(
				"Google Nexus 7 is the lightest7 inch tablet With a quad-core Qualcomm Snapdragon™ S4 Proprocessor");
		tablet_Nexus.setCategory(Enum.TABLET.getName());
		tablet_Nexus.setManufacturer(Enum.GOOGLE.getName());
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

	@Override
	public Product getProductById(String productId) {
		Product product = null;
		for (Product p : listOfProducts) {
			if (p != null && p.getProductId() != null && p.getProductId().equals(productId)) {
				product = p;
				break;
			}
		}
		if (product == null) {
			throw new IllegalArgumentException("No products found with	the product id: " + productId);
		}
		return product;
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		List<Product> products = new ArrayList<Product>();
		for (Product p : listOfProducts) {
			if (p != null && p.getCategory() != null && p.getCategory().equals(category)) {
				products.add(p);
			}
		}
		if (products.isEmpty()) {
			throw new IllegalArgumentException("No products found with	the product id: " + category);
		}
		return products;
	}

	@Override
	public List<Product> getProductByFilter(Map<String, List<String>> filterParams) {
		// TODO Auto-generated method stub
		List<Product> productByBrand = new ArrayList<Product>();
		List<Product> productByCatagory = new ArrayList<Product>();

		List<String> criterias = new ArrayList<>(filterParams.keySet());

		if (criterias.contains(Enum.BRAND.getName())) {
			for (String brandName : filterParams.get(Enum.BRAND.getName())) {
				for (Product product : listOfProducts) {
					if (product.getManufacturer().equalsIgnoreCase(brandName)) {
						productByBrand.add(product);
					}
				}
			}
		}

		if (criterias.contains(Enum.CATEGORY.getName())) {
			for (String category : filterParams.get(Enum.CATEGORY.getName())) {
				for (Product product : productByBrand) {
					if (product.getCategory().equalsIgnoreCase(category)) {
						productByCatagory.add(product);
					}
				}
			}
		}

		return productByCatagory;
	}

	@Override
	public List<Product> getProductsByManufacturer(String manufacturer) {
		// TODO Auto-generated method stub
		List<Product> productByBrand = new ArrayList<Product>();
		for (Product product : listOfProducts) {
			if (product.getManufacturer().equalsIgnoreCase(manufacturer)) {
				productByBrand.add(product);
			}
		}
		return productByBrand;
	}

	@Override
	public List<Product> getProductsBypriceFilter(Map<String, BigDecimal> filterParams) {
		List<Product> productByLow = new ArrayList<Product>();
		List<Product> productByHigh = new ArrayList<Product>();
		List<String> criterias = new ArrayList<>(filterParams.keySet());
		if (criterias.contains(Enum.LOW.getName())) {
			for (Product product : listOfProducts) {
				if (product.getUnitPrice().compareTo(filterParams.get(Enum.LOW.getName())) < 0) {

				}
			}
		}
		return productByHigh;
	}

	@Override
	public void addProduct(Product product) {
		listOfProducts.add(product);

	}

}
