package com.example.libs;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/servlets/servlet/ContextDemo")		//web.xml쓸 것이므로 이 부분 주석처리
public class ContextDemoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//Context만드는 방법
		ServletContext ctx = this.getServletContext();
		Enumeration<String> enums = ctx.getInitParameterNames(); 	//강사님 언급 : 각 서블릿 (InitParameter)의 초기값을 설정(?)하기 위해	context-param을 Init-param으로 가져와서 설정...?	//모든 context-param을 가져옴.	//db.url, db.password, db.driver, db.user	//Init-parameter의 모든 파라미터 (DB정보 저장된 4개의 파라미터)의 이름만 가져옴
																//Context의 getInitParameterNames()
		//Enumeration : 벌크로 땡겨옴
		while(enums.hasMoreElements()) {
			String name = enums.nextElement(); 			//db.url, db.user, ...
			String value = ctx.getInitParameter(name);
			System.out.println(name + " ---> " + value);
		}
	}

}
