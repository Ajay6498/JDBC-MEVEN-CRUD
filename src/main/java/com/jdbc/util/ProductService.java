package com.jdbc.util;

abstract public class ProductService {
	abstract public String addProduct(Product prod) throws InvalidProductType,InvalidProductId,InvalidAttribute,DuplicateProduct;
	abstract public boolean deleteProduct(int prodId)throws InvalidProductId;
	abstract public Product updateProduct(int prodId,Product newValues);
	abstract public Product getProduct(int prodId);
	abstract public Product[] getAllProduct();
}
