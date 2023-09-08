package com.jdbc.util;

public class Product {			// Product			prod_info
	private int prodId;			//prodId		    prod_id
	private String prodName;	//prodName		
	private double prodPrice;
	private String prodVendor;
	private int prodQty;
	public Product(int prodId, String prodName, double prodPrice, String prodVendor, int prodQty) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodVendor = prodVendor;
		this.prodQty = prodQty;
	}
	@Override
	public String toString() {
		return "\n Product [prodId=" + prodId + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodVendor="
				+ prodVendor + ", prodQty=" + prodQty + "]";
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public double getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getProdVendor() {
		return prodVendor;
	}
	public void setProdVendor(String prodVendor) {
		this.prodVendor = prodVendor;
	}
	public int getProdQty() {
		return prodQty;
	}
	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}
	
	
}
