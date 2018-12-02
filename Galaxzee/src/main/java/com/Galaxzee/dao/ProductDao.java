package com.Galaxzee.dao;

import java.util.List;

import com.Galaxzee.model.Product;

public interface ProductDao 
{
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(int productId);

	public Product getProduct(int productId);
	public List<Product> listProducts();
}
