package com.integrate;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GZipResponseWrapper extends HttpServletResponseWrapper {

	private HttpServletResponse response;
	private GZipOutputStream gzipOutputStream;
	private PrintWriter writer;

	public GZipResponseWrapper(HttpServletResponse response) {
		super(response);
		this.response=response;
	}
	
	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		if(gzipOutputStream==null)
			gzipOutputStream=new GZipOutputStream(response);
		return gzipOutputStream;
	}
	
	@Override
	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
		if(writer==null) {
			writer=new PrintWriter(new OutputStreamWriter(new GZipOutputStream(response), "UTF-8"));
		}
		return writer;
	}
	
	@Override
	public void setContentLength(int len) {}
	
	@Override
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		gzipOutputStream.flush();
	}
	
	public void finishResponse() throws IOException {
		if(gzipOutputStream!=null)
			gzipOutputStream.close();
		if(writer!=null)
			writer.close();
	}
	
	

}
