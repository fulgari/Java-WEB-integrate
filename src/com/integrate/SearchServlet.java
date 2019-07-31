package com.integrate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String word = request.getParameter("word");
		String type = request.getParameter("type");
		String allowedAdult=request.getParameter("allowedAdult");
		boolean adultOk="true".equals(allowedAdult);
		
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><TITLE>"+word+" Search Results</TITLE></HEAD>");
		out.println("<style>body, div{font-size:12px;}</style>");
		out.println("<style> .result__extras, .result__snippet {font-size:12px;display: flex; position: relative; text-decoration: none;}</style>");
		
		StringBuffer sbuff = new StringBuffer();
        try {  
            URL url = new URL("https://duckduckgo.com/html/?q="+word);  
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setRequestMethod("GET");  
            httpUrlConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            InputStream input = httpUrlConn.getInputStream();
            InputStreamReader read = new InputStreamReader(input, "utf-8");
            BufferedReader br = new BufferedReader(read);  
            String data = br.readLine();
            while(data!=null)  {
                sbuff.append(data);
                data=br.readLine();
            }  
            br.close();  
            read.close();  
            input.close();  
            httpUrlConn.disconnect();  
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

		
		String content = sbuff.toString();
		out.print(content);
		String regex = "<div class=\"result results_links results_links_deep web-result \">.*<div class=\"result results_links results_links_deep web-result \">";
		Pattern pattern = Pattern.compile(regex);  
		Matcher matcher = pattern.matcher(content);  
		if(matcher.find()){  
		    for(int i=0; i<=matcher.groupCount(); i++){  
		        out.println(i+":"+matcher.group(i));  
		    }  
		}  

		out.println("<b>The String array injected </b>: <br/>");
		
		
		out.println("<BODY>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
