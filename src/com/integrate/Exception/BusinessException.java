package com.integrate.Exception;

public class BusinessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BusinessException(String s) {
		System.err.println(s);
	}

}
