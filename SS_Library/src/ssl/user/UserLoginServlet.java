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

import ssl.dto.UserDTO;
import ssl.service.UserService;

@WebServlet("/login.do")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// 로그인 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
				
		// email, pass를 받아옴
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String src = (String) session.getAttribute("src");
				
		// 서비스 불러옴	
		UserService service = new UserService();		
		UserDTO dto = service.loginUser(email, pass);

		String result_url = "";
		PrintWriter out = response.getWriter();

		if(dto == null)
		{ // id 혹은 비밀번호가 다름.
			out.println("<script language='javascript'>");
			out.println("alert('ID 혹은 비밀번호가 다릅니다. 다시 입력해주세요.');");
			out.println("history.back();");	
			out.println("</script>");

		}
		else if(dto != null)
		{ // 정상적으로 처리 됨.
			result_url = "./FrontController?src=" + src;
			session.setAttribute("user", dto); // 객체를 세션에 담아줌.
			RequestDispatcher rdp = request.getRequestDispatcher(result_url);
			rdp.forward(request, response);
		}
	}

}
