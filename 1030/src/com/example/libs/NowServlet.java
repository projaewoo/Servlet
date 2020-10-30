package com.example.libs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		String today = String.format("<h3> 오늘은 %1$tY년 %1$tm월 %1$td일 입니다.</h3>",
				new Date());
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(today);		
		
//		out.close(); 	//절대로 부품은 close하면 안됨.	//close() 밑에 문장 쓰면 안 나옴.
	}
}