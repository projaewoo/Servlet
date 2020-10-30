package com.example.libs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlets/servlet/Silver")
public class SilverServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("userage"));
		
		response.setContentType("text/html;   charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<body style = 'background-color : silver'>");
		out.println("<h1>This page is a Silver's page</h1>");
		out.println("이름 : " + username + "<br />");
		out.println("나이 : " + age);
		out.println("</body>");
		out.close();
	}
}