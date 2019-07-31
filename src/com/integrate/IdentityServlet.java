package com.integrate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IdentityServlet
 * #usage: generates Verification code
 */
@WebServlet("/IdentityServlet")
public class IdentityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final char[] CHARS= {'2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','L','J','K','M','N','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public static Random random = new Random();
    
    public static String getRandomString() {
    	StringBuffer buffer = new StringBuffer();
    	for(int i=0; i<6; i++) {
    		buffer.append(CHARS[random.nextInt(CHARS.length)]);
    	}
    	return buffer.toString();
    }
    
    public static Color getRandomColor() {
    	return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }
    
    public static Color getReverseColor(Color c) {
    	return new Color(255-c.getRed(),255-c.getGreen(),255-c.getBlue());
    }
    
    public IdentityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("image/jpeg");
		String randomString = getRandomString();
		request.getSession(true).setAttribute("randomString", randomString);
		
		int width=100;
		int height=30;
		
		Color color = getRandomColor();
		Color reverse = getReverseColor(color);
		
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		g.setColor(color);
		g.fillRect(0, 0, width, height);
		g.setColor(reverse);
		g.drawString(randomString, 18, 20);
		g.drawLine(0, random.nextInt(height), width, random.nextInt(height));
		g.drawLine(0, random.nextInt(height), width, random.nextInt(height));
		for(int i=0, n=random.nextInt(100); i<n; i++) {
			g.drawRect(random.nextInt(width), random.nextInt(width), 1, 1);
		}
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpeg", out);
		out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
