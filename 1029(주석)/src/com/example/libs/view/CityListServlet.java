package com.example.libs.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.libs.controller.SelectService;
import com.example.libs.model.CityVO;

@WebServlet("/servlets/servlet/CityList")		//example.com/1029/servlets/servlet/CityList와 동일.
public class CityListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
			String code = req.getParameter("code");		//"KOR"	//유저에서 서버로 들어오는 것 : req
			//example.com/1029/servlets/servlet/CityList?code=KOR		//KOR를 code가 저장
			
			ArrayList<CityVO> list = SelectService.getCityList(code);		//SelectService의 getCityList() 호출.	//getCityList()의 반환값을 list에 저장.
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<head>");
			out.println("<link rel = 'stylesheet'  href='../../css/style.css'>");
			out.println("<script src = '../../js/myaction.js'></script> ");
			out.println("</head>");
			
			out.println("<h1>CountryCode = " + code + "</h1>");
			out.println("<div><button>뒤로가기</button></div><br />");
			out.println("<table>");
			out.println("<thead>");
			out.print("<tr><td>ID</th><th>Name</th><th>CountryCode</th>");
			out.println("<th>District</th><th>Population</th></tr>");
			out.println("</thead>");
			out.println("<tbody>");
			for(int i = 0 ; i < list.size(); i++) {
				out.println(list.get(i));		//list.get(i).toString()
			}	
			out.println("</tbody>");
			out.println("</table>");
			
			out.close();
	}
}
	