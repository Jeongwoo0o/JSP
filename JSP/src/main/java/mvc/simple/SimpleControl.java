package mvc.simple;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/SimpleControl", "*.do"})
public class SimpleControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SimpleControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// [1] 사용자의 요청(request)을 받음
		String type = request.getParameter("type");
		
		// [2] 사용자의 요청에 따라 알맞은 기능을 수행
		String value = "";
		if(type == null) value="안녕하세요";
		else if(type.equals("first")) value="홍길동 화이팅!!";
		
		// [3] 처리결과를 request or session에 저장
		request.setAttribute("param", value);
		
		// [4] forwarding <jsp:forward>
		RequestDispatcher disp = request.getRequestDispatcher("/07_mvc_class/1_mvcSimple/simpleView.jsp");
		disp.forward(request, response);
	}
}
