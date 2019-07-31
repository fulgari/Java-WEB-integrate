package com.integrate;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CacheResponseWrapper extends HttpServletResponseWrapper {

	private CharArrayWriter cacheWriter = new CharArrayWriter();
	
	public CacheResponseWrapper(HttpServletResponse response) {
		super(response);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
		return new PrintWriter(cacheWriter);
	}
	
	@Override
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		cacheWriter.flush();
	}
	
	public void finishResponse() {
		cacheWriter.close();
	}
	
	public CharArrayWriter getCacheWriter() {
		return cacheWriter;
	}
	
	public void setCacheWriter(CharArrayWriter cacheWriter) {
		this.cacheWriter = cacheWriter;
	}

}
