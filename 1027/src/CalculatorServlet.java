import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String result = this.calc(req);
		
		//res : 서버에서 나가는 쪽
		res.setContentType("text/html; charset = utf-8");
		PrintWriter out = res.getWriter();
		out.println(result);		//한 번에 result 내보냄.
		out.println("<hr>");
		out.println("<img src='../../images/ramen.jpg'   alt='라면 이미지'> ");		
		// 경로 = http://www.example.com/1027/servlets/servlet/Calculator
		//			../  =  (Calculator의 부모)servlet
		//			../../  =  (Calculator의 할머니)servlets
		// 			../../images  =  Calculator 위에 위에의 형제인 images
		//  		../../images  = ../.././images  (Calculator 위에 위에의 형제인 images)
		// 			../../../   =   (증조 할머니)1027
		out.close();
	}
	
	private String calc(HttpServletRequest req) {
		int count = 0;
		String name = req.getParameter("irum");		//req : 서버로 들어오는 것.
		String today = String.format("귀하가 방문한 날짜는 %1$tY년 %1$tm월 %1$td일 입니다.",		//1$ : 첫번째 args (new Date())로 찍어라			//원래 new Date() 3개 해야하는데, 1$로 new Date() 하나만 해도 됨. 
									new Date());
		//정답 저장한 배열
		int [] array = {(5 + 6), (8 - 3), (7 * 6), (15 / 3), (8 + 6 - 3 * 2 / 2)};
		for(int i = 1 ; i < 6 ; i++) {
			String quest = req.getParameter("question" + i);
			//숫자로 바꿔서 비교
			int su = Integer.parseInt(quest);		//"11" -> 11
			if(su == array[i - 1]) {
				count++;
			}
		}
		String str = "<span style = 'color : blue'>" + name + "</span>님! <br />";
		str += today + "<br />";
		str += array.length + "문제 중 " + (array.length - count) + "개를 틀려서 "
					 +	"<span style = 'color : red'>" + (count * 20) + "점</span> 입니다!";
		return str;
	}
}
