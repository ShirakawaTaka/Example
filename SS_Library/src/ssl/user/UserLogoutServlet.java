package ssl.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout.do")
public class UserLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf8");
		HttpSession session = request.getSession();
		String src = (String) session.getAttribute("src");
		String url = null;
		PrintWriter out = response.getWriter();
		
		if(session.getAttribute("user") != null)
		{
			session.invalidate();
			url = "./FrontController?src="+src;
			out.println("<script language='javascript'>");
			out.println("alert('로그아웃 되었습니다.');");
			out.println("history.back();");	
			out.println("</script>");
		}
		else {
			url = "./FrontController?src="+src;
			out.println("<script language='javascript'>");
			out.println("alert('잘못된 접근입니다.');");
			out.println("</script>");
		}

		RequestDispatcher rdp = request.getRequestDispatcher(url);
		rdp.forward(request, response);

	}
}
