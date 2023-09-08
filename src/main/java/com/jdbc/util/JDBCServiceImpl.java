package com.jdbc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCServiceImpl extends ProductService {

	public String addProduct(Product prod)  throws InvalidProductType, InvalidProductId, InvalidAttribute, DuplicateProduct {
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
			Connection conn = JDBCUtil.getConnection();
			Statement stmt = null;
			try {
				stmt = conn.createStatement();
				String insert_query = String.format(AppQueries.INSERT_PRODUCT,prod.getProdId(),prod.getProdName(),prod.getProdQty(),prod.getProdPrice(),prod.getProdVendor());;
				System.out.println("insert_query -->"+insert_query);
				stmt.executeUpdate(insert_query);		//execute[boolean] -- executeUpdate [int]		--> excuteQuery[ResultSet]
				return "Product Added Successfully...!";
			} catch (SQLException e) {
				e.printStackTrace();
				return "Please try after sometime--contact to support/admin team--";
			}finally {
				JDBCUtil.closeResources(conn,stmt,null);
			}
		}
	}

	public boolean deleteProduct(int prodId) throws InvalidProductId {
		
		if(prodId<=0) {
			throw new InvalidProductId("Invalid Product ID exception..!");
		}
		
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = null;
		ResultSet resultSet = null;
		
		
		try {
			stmt = conn.createStatement();
			String delete_query = String.format(AppQueries.DELETE_PRODUCT,prodId);
			stmt.executeUpdate(delete_query);
			return true;
		}catch(Exception e) {
			return false;
		}finally {
			JDBCUtil.closeResources(conn, stmt, resultSet);
		}
	}

	public Product updateProduct(int prodId, Product newValues) {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			stmt = conn.createStatement();
			String update_query = String.format(AppQueries.UPDATE_PRODUCT,newValues.getProdName(),newValues.getProdQty(),newValues.getProdPrice(),newValues.getProdVendor(),newValues.getProdId());
			stmt.executeUpdate(update_query);
			return getProduct(prodId);
		}catch(Exception e) {
			return null;
		}finally {
			JDBCUtil.closeResources(conn, stmt, resultSet);
		}
	}

	public Product getProduct(int prodId) {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			stmt = conn.createStatement();
			String get_query = String.format(AppQueries.GET_SINGLE_PRODUCT,prodId);
			resultSet = stmt.executeQuery(get_query);
			while(resultSet.next()) {
				String name = resultSet.getString("prod_name");
				int qty = resultSet.getInt("prod_qty");
				String ven = resultSet.getString("prod_vendor");
				double price = resultSet.getDouble("prod_price");
				int pid = resultSet.getInt("prod_id");
				return new Product(pid,name,price,ven,qty);
			}
		}catch(Exception e) {
			return null;
		}finally {
			JDBCUtil.closeResources(conn, stmt, resultSet);
		}
		return null;
	}

	public Product[] getAllProduct() {
		Connection conn = JDBCUtil.getConnection();
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(AppQueries.GET_ALL_PRODUCTS);
			Product products[] = new Product[resultSet.getFetchSize()];
			int index = 0;
			while(resultSet.next()) {
				String name = resultSet.getString("prod_name");
				int qty = resultSet.getInt("prod_qty");
				String ven = resultSet.getString("prod_vendor");
				double price = resultSet.getDouble("prod_price");
				int pid = resultSet.getInt("prod_id");
				products[index++] = new Product(pid,name,price,ven,qty);
			}
			return products;
		}catch(Exception e) {
			return null;
		}finally {
			JDBCUtil.closeResources(conn, stmt, resultSet);
		}
	}

}
