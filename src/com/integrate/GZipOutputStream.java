package com.integrate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;

public class GZipOutputStream extends ServletOutputStream {

	private HttpServletResponse response;
	private GZIPOutputStream gzipOutputStream;
	private ByteArrayOutputStream byteArrayOutputStream;
	
	public GZipOutputStream(HttpServletResponse response) throws IOException {
		this.response=response;
		byteArrayOutputStream=new ByteArrayOutputStream();
		gzipOutputStream=new GZIPOutputStream(byteArrayOutputStream);
	}

	@Override
	public void close() throws IOException {
		gzipOutputStream.finish();
		byte[] content = byteArrayOutputStream.toByteArray();
		response.addHeader("Content-Encoding", "gzip");
		response.addHeader("Content-Length", Integer.toString(content.length));
		
		ServletOutputStream out = response.getOutputStream();
		out.write(content);
		out.close();
	}
	
	@Override
	public void flush() throws IOException {
		gzipOutputStream.flush();
	}
	
	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		gzipOutputStream.write(b, off, len);
	}
	
	@Override
	public void write(byte[] b) throws IOException {
		// TODO Auto-generated method stub
		gzipOutputStream.write(b);
	}
	
	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setWriteListener(WriteListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void write(int b) throws IOException {
		gzipOutputStream.write(b);

	}

}
