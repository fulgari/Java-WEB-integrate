package com.integrate.Exception;

public class AccountException extends Exception{
	private static final long serialVersionUID = 1L;
	public AccountException(String s) {
		System.err.println(s);
	}

}
