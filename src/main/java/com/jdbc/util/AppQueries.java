package com.jdbc.util;

 interface AppQueries {
	
	 String INSERT_PRODUCT = "INSERT INTO PROD_INFO VALUES(%d,'%s',%d,%.2f,'%s')";
	 String UPDATE_PRODUCT = "UPDATE PROD_INFO SET PROD_NAME = '%s',PROD_QTY = %d,PROD_PRICE=%.2f,PROD_VENDOR='%s' WHERE PROD_ID = %d";
	 String DELETE_PRODUCT = "DELETE FROM PROD_INFO WHERE PROD_ID =%d";
	 String GET_SINGLE_PRODUCT = "SELECT * FROM PROD_INFO WHERE PROD_ID = %d";
	 String GET_ALL_PRODUCTS = "SELECT * FROM PROD_INFO";
	
	
}
