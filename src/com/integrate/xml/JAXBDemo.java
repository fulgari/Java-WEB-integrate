package com.integrate.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBDemo {

	public static void main(String[] args) {
		File xmlFile=new File("D:\\Project Zijun\\Logiciels\\eclipse\\eclipse-workspace\\Integrate\\output\\test.xml");
		JAXBContext context;
//		try {
//			context=JAXBContext.newInstance(Article.class);
//			Marshaller m=context.createMarshaller();
//			
//			Article article=new Article();
//			article.setAuthor("Janet");
//			article.setDate("20080601");
//			article.setEmail("jj@yahoo.com");
//			article.setTitle("XML");
//			
//			m.marshal(article, xmlFile);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			context=JAXBContext.newInstance(Article.class);
			Unmarshaller un=context.createUnmarshaller();
			Article article =(Article) un.unmarshal(xmlFile);
			System.out.println(article.getAuthor());
			System.out.println(article.getTitle());
			System.out.println(article.getEmail());
			System.out.println(article.getDate());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
