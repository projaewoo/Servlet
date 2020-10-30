package com.example.libs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Redirect 처리
//
@WebServlet("/servelts/servlet/Register1")			//url : localhost:8080/1030/servlets/servlet/Register1으로 들어오면 이 클래스파일 열게 해!!
public class RegisterServlet1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		int age = Integer.parseInt(request.getParameter("userage"));		//userage = "24" = String
		if(age < 20) {
			response.sendRedirect("https://jr.naver.com/");
		}else if(age < 65) {
			out.println("<script>");
			out.println("location.href = 'https://www.youtube.com'; ");		//
			out.println("</script>");
		}else {
			response.sendRedirect("/1030/servlets/servlet/Silver");
		}
		
		out.close();
		
	}
}