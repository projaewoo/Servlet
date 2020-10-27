import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HangulServlet extends HttpServlet {
	@Override
	//부모 : public //자식 : public or protected (부모보다 범위 좁아야함)
	//doGet : GET방식.
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
     throws ServletException, IOException {
		//톰캣 -> 아파치 -> 유저
		
		res.setContentType("text/html;charset=utf-8");		//터널 통해 나가는 파일의 유형을 html로 알림	//charset = utf-8 : 한글 깨짐 방지
		PrintWriter out = res.getWriter();
		out.println("<p style = 'color : blue'>안녕 서블릿</p>");
		out.close();
	}
}
