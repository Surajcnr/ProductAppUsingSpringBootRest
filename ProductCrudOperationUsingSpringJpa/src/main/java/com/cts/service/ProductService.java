package com.cts.service;

import java.util.List;

import com.cts.exception.ProductNotFoundException;
import com.cts.model.Product;

public interface ProductService {
	public abstract String saveProduct(Product product);

	public abstract Product updateProduct(Product product);

	public abstract String removeProduct(int productId);

	public abstract Product getProduct(int productId) throws ProductNotFoundException;

	public abstract List<Product> getAllProducts();

	public abstract List<Product> getAllProductsBetween(int intitalPrice, int finalPrice);

	public abstract List<Product> getAllProductsByCategory(String category);

	public abstract List<Product> getAllProductsAboveGivenPrice(int price);
}
