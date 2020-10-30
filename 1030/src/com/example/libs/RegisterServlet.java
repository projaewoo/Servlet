package com.example.libs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servelts/servlet/Register")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		int age = Integer.parseInt(request.getParameter("userage"));		//userage = "24" = String
		if(age < 20) {
			
			//방법1 : 코드 길다.
//			ServletContext context = this.getServletContext();
//			RequestDispatcher teenage = 
//					context.getRequestDispatcher("/servlets/servlet/Teen");
			
			//방법2 : 코드 간결.
			RequestDispatcher teenage = 
					request.getRequestDispatcher("/servlets/servlet/Teen");		// 반드시 /로 시작하는 상대경로!!
			
			teenage.forward(request, response);
		}else if(age < 65) {
			RequestDispatcher adult = 
					request.getRequestDispatcher("/servlets/servlet/Adult");		// 반드시 /로 시작하는 상대경로!!
			adult.forward(request, response); 
		}else {
			RequestDispatcher silver = 
					request.getRequestDispatcher("/servlets/servlet/Silver");		// 반드시 /로 시작하는 상대경로!!
			silver.forward(request, response);
		}
		
	}
}