<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ssl.dto.BoardDTO" %>
<%@ page import = "ssl.dto.UserDTO" %>
<%@ page import = "ssl.service.BoardService" %>
<%@ page import = "java.util.*" %>

<% BoardService service = new BoardService();
int ss_no = Integer.parseInt(request.getParameter("ss_no"));
BoardDTO dto = service.getOneSS(ss_no);
UserDTO user_dto = (UserDTO) session.getAttribute("user");
String src = (String) session.getAttribute("src");
%>
    
<div class="container top-margin-ss">
	<div id ="boardheader">
		<h3><%=dto.getTitle() %></h3>
		<span>by. <%=dto.getUser_no() %></span>&nbsp;&nbsp;<span><%=dto.getWriter_day() %></span>
	</div>
	<hr />
	<div id="writer_comment">
		<%=dto.getWriter_comment() %>
	</div>
	<hr />
	<div id="main_content">
		<%=dto.getMain_content() %>
	</div>
	<hr />
	<div id="goboardlist" class="row">
		<div align="left" style="width: 50%">
		<button class="btn btn-default" onclick="location.href = './FrontController?src=<%=src%>'">목록으로</button>
		</div>
		<div align="right" style="width: 50%">
			<% 	if(user_dto != null) {
				if(user_dto.getUser_no() == dto.getUser_no()) { %>
			<button class="btn btn-default" onclick="location.href = './FrontController?src=ss_modify&ss_no=<%=dto.getSs_no()%>'">수정</button>
			<button class="btn btn-default" onclick="location.href = 'delete.do?ss_no=<%=dto.getSs_no()%>'">숨기기</button>
			<% }} %>
		</div>
	</div>
</div>