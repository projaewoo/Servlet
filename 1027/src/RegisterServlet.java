import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException {
		//톰캣 : 아래 코드 처리 -> 아파치 -> 유저
		
		//req : 유저 -> 서버 (서버로 들어오는 쪽)
		//res : 유저 <- 서버 (서버에서 나가는 쪽)
		

		req.setCharacterEncoding("utf-8");		//POST방식일때만 필터 통해서 한글 처리
		String username = req.getParameter("username");		//input의 name : username //username 텍스트박스 에 들어있는 변수의 값을 String username에 넣음.
		String today = String.format("%1$tY년 %1$tm월 %1$td일 입니다.", new Date());
		
		
		res.setContentType("text/html; charset = utf-8");
		PrintWriter out = res.getWriter();		//나가는 쪽 res
		out.println("<div>");
		out.println("<span style = 'color : blue'>" + username + "</span>");
		out.println("님! 귀하의 방문 시간은 </div>");
		out.println("<div>" + today + "</div>");
		
		out.close();
	}
}
