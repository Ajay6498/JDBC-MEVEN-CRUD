package com.jdbc.util;




class InvalidProductId extends Exception{
	public InvalidProductId(String message) {
		super(message);
	}
}

class DuplicateProduct extends Exception{
	public DuplicateProduct(String message) {
		super(message);
	}
}

class ProductNotFound extends Exception{
	public ProductNotFound(String message) {
		super(message);
	}
}

class NoRecordsPresent extends Exception{
	public NoRecordsPresent(String message) {
		super(message);
	}
}

class InvalidAttribute extends Exception{
	public InvalidAttribute(String message) {
		super(message);
	}
}

