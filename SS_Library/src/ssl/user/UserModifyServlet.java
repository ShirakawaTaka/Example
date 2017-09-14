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

@WebServlet("/modify.do")
public class UserModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nickName = request.getParameter("nickname");
		int user_no = Integer.parseInt(request.getParameter("user_no"));
		String url = null;
		
		UserDTO dto = new UserDTO(email, password, nickName);
		UserService service = new UserService();
		UserDTO temp = service.modifyUser(dto, user_no);
		if(temp == null)
		{
			// 만약 조인이 실패하였다면 
			// 회원가입 페이지로 돌아감. (메시지출력)
			PrintWriter out = response.getWriter();
			url = "./FrontController?src=main";
			out.println("<script language='javascript'>");
			out.println("alert('입력정보에 오류가 있습니다. 다시 입력해주세요.');");
			out.println("history.back();");	
			out.println("</script>");
		}
		else
		{
			// 조인에 성공했다면. 메인으로감.
			HttpSession session = request.getSession();
			session.setAttribute("user", temp);
			PrintWriter out = response.getWriter();
			url = "./FrontController?src=modify";
			out.println("<script language='javascript'>");
			out.println("alert('정보 수정에 성공하셨습니다.');");
			out.println("</script>");
		}
		
		RequestDispatcher rdp = request.getRequestDispatcher(url);
		rdp.forward(request, response);
	}

}
