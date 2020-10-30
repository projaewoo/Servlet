package com.example.libs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IncludeDemo extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String today = String.format("<h3> 오늘은 %1$tY년 %1$tm월 %1$td일 입니다.</h3>",
														new Date());
		PrintWriter out = response.getWriter();
		//header 위의 뚜껑에 넣을 문장.
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		
		RequestDispatcher header =
				request.getRequestDispatcher("/header.html");			//1030/images/chicken.jpg 이미지 보여줘
		//HttpServletRequest 의 부모 : ServletRequest		//따라서 부모의 메소드 사용 가능
		header.include(request, response); 		//header에 header.html찍음.	//Tomcat -> Apache ->유저가 header를 받아봄.

		RequestDispatcher body = 
				request.getRequestDispatcher("/servlets/servlet/Now");			//web.xml에 써줘야 Now가 뭔지 알 수 있음.
		body.include(request, response); 
		
		RequestDispatcher footer =
//				request.getRequestDispatcher("https://www.naver.com");	//path : 반드시 상대경로. (경로 : /로 시작)
				request.getRequestDispatcher("/copyright.html");		//1030/IncludeDemo가 1030/copyright.html 호출.
		footer.include(request, response);		//footer에 copyright.html 찍음.		//Tomcat -> Apache ->유저가 footer를 받아봄.
		
		out.println("</html>");
		out.close();
	}
}