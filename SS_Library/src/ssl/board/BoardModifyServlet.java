package ssl.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ssl.dto.BoardDTO;
import ssl.service.BoardService;

@WebServlet("/modifyBoard.do")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		
		// 요청 처리
		int user_no = Integer.parseInt(request.getParameter("user_no"));
		String title = request.getParameter("title");
		String writer_comment = request.getParameter("writer_comment");
		String main_content = request.getParameter("main_content");
		String tags = request.getParameter("tags");
		int ss_no = Integer.parseInt(request.getParameter("ss_no"));
		String src = (String) session.getAttribute("src");
		
		BoardDTO dto = new BoardDTO(user_no, title, writer_comment, main_content);
		BoardService service = new BoardService();
		service.modifySS(dto, ss_no);
		
		String result_url = "./FrontController?src=" + src;
		RequestDispatcher rdp = request.getRequestDispatcher(result_url);
		rdp.forward(request, response);
	}

}
