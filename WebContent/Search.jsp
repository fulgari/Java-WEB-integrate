<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.net.*" import="java.io.*" import="java.util.regex.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search JSP</title>
</head>
<body>

<%
StringBuffer sbuff = new StringBuffer();
try{
URL url = new URL("https://duckduckgo.com/html/?q="+request.getParameter("word")); 
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

%>
</body>
</html>