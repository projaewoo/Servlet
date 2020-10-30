package com.example.libs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/LocalDemoServlet")		//web.xml쓸 것이므로 이 부분 주석처리
public class LocalDemoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
//		Enumeration<String> enums = this.getInitParameterNames();		//파라미터 다 가져와
//													//this의 getInitParameterNames()
//		while(enums.hasMoreElements()) {
//			String name = enums.nextElement();					
//			String value = this.getInitParameter(name); 			//C:/temp/mysql.properties
//			System.out.println(name + " --> " + value);
//		}
		String filename = this.getInitParameter("mariadb.properties");	//파라미터 이름 : mariadb.properties인 value 가져옴	//C:/temp/mariadb.properties
		DBConnection dbconn = new DBConnection(filename);
		Connection conn = dbconn.getConnection();		//2, 3step
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>" + conn + "</h2>");
//		System.out.println(conn);
		DBClose.close(conn);			//7step
		out.close();
	}
}