package ssl.searchtags;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/search.do")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//서치는 겟으로만 작동
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		
		String[] search = new String[1];
		search[0] = request.getParameter("search");
		
		String result_url = "./FrontController?src=board";
		request.setAttribute("tags", search);
		RequestDispatcher rdp = request.getRequestDispatcher(result_url);
		rdp.forward(request, response);		
	}
}
