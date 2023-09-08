package com.jdbc.util;

public class StartApp {
		
	public static void main(String[] args) {
		Product p1 = new Product(772,"XXXX", 12892.23, "Snapdeal", 2);
		Product p2 = new Product(773,"XXXX", 12892.23, "Snapdeal", 2);
		Product p3 = new Product(774,"XXXX", 12892.23, "Snapdeal", 2);
		Product p4 = new Product(775,"XXXX", 12892.23, "Snapdeal", 2);
		Product p5 = new Product(776,"XXXX", 12892.23, "Snapdeal", 2);
		
		ProductService memoryService = new InMemoryServiceImpl();
		
		try {
			String msg = memoryService.addProduct(p1);
			System.out.println(msg);
		} catch (InvalidProductType e) {
			e.printStackTrace();
		} catch (InvalidProductId e) {
			e.printStackTrace();
		} catch (InvalidAttribute e) {
			e.printStackTrace();
		} catch (DuplicateProduct e) {
			e.printStackTrace();
		}
		
		System.out.println("JDBC -- OPERATIONS");
		
		ProductService jdbcService  = new JDBCServiceImpl();
		try {
			String msg = jdbcService.addProduct(p1);
			System.out.println(msg);
		} catch (InvalidProductType e) {
			e.printStackTrace();
		} catch (InvalidProductId e) {
			e.printStackTrace();
		} catch (InvalidAttribute e) {
			e.printStackTrace();
		} catch (DuplicateProduct e) {
			e.printStackTrace();
		}
	}
}
