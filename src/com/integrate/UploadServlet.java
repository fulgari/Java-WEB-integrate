package com.integrate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println("pleas use POST to upload msg!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		File file1=null, file2=null;

		DiskFileItemFactory factory= new DiskFileItemFactory();
		ServletFileUpload sfile = new ServletFileUpload(factory);
        try {
        	List<FileItem> list=sfile.parseRequest(request);
        	out.println("run throw all the FileItem...<br/>");
        	for(FileItem fi : list) {
        		if("file1".equals(fi.getFieldName())) {
        			File remoteFile = new File(new String(fi.getName().getBytes(),"UTF-8"));
        			out.println("run to file1...<br/>");
        			out.println("file path:"+remoteFile.getAbsolutePath()+"<br/>");
        			file1=new File(this.getServletContext().getRealPath("attachment"),remoteFile.getName());
        			file1.getParentFile().mkdirs();
        			file1.createNewFile();
        			InputStream ins = fi.getInputStream();
        			OutputStream ous = new FileOutputStream(file1);
        			try {
        				byte[] buff = new byte[1024];
        				int len=0;
        				while((len=ins.read(buff))>-1) ous.write(buff,0,len);
        				out.println("file saved:"+file1.getAbsolutePath()+"<br/>");
        			} finally {
        				ous.close();
        				ins.close();
        			}
        		}
        	}
        } catch (Exception e) {}
        finally {
        	out.close();
        }
	}

}