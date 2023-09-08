package com.jdbc.util;

import java.util.Arrays;

public class InMemoryServiceImpl extends ProductService{
	public static Product products[] = new Product[0];
	public static int prodIndex = 0;
	public String addProduct(Product prod) throws InvalidProductType, InvalidProductId, InvalidAttribute, DuplicateProduct {
		if(null == prod) {
			throw new InvalidProductType("Invalid Product Type");
		}else if(prod.getProdId()<=0) {
			throw new InvalidProductId("Invalid Product Id...excepted Value --> Greater Than Zero");
		}else if(prod.getProdPrice()<=0) {
			throw new InvalidAttribute("Invalid Price..!");
		}
		Product memoryProduct = getProduct(prod.getProdId());
		
		if(memoryProduct!=null) {
			throw new DuplicateProduct("Product With Given Id Already Exist.!");
		}else {
			products = Arrays.copyOf(products, products.length+1);
			products[prodIndex++] = prod;
			return "Product Added Successfully...!";
		}
	}

	public boolean deleteProduct(int prodId) {
		return false;
	}

	public Product updateProduct(int prodId, Product newValues) {
		return null;
	}

	public Product getProduct(int prodId) {
		return null;
	}

	public Product[] getAllProduct() {
		return null;
	}

}
