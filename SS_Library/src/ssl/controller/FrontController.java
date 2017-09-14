package ssl.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String src = request.getParameter("src");
		
		if(src.equals("logout")) src = "logout.do";
		else if(src.equals("board")) src = "main/boardMode.jsp";
		else if(src.equals("join")) src = "user/join.jsp";
		else if(src.equals("modify")) src = "user/userModify.jsp";
		else if(src.equals("write")) src = "board/writeForm.jsp";
		else if(src.equals("view")) src = "board/viewBoard.jsp";
		else if(src.equals("ss_modify")) src = "board/editForm.jsp";
		else src = "main/previewMode.jsp";
		
		request.setAttribute("pageindex", src);
		RequestDispatcher rdp = request.getRequestDispatcher("./index.jsp");
		rdp.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
