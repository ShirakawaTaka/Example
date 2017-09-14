<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ssl.dto.UserDTO" %>
<%@ page import = "ssl.dto.BoardDTO" %>
<%@ page import = "ssl.service.BoardService" %>
<%@ page import = "java.util.*" %>
<% UserDTO dto = (UserDTO) session.getAttribute("user");
BoardService service = new BoardService();
int ss_no = Integer.parseInt(request.getParameter("ss_no"));
BoardDTO board_dto = service.getOneSS(ss_no);
String src = (String) session.getAttribute("src");
%>


<style>
.write-form-width {
	width : 100%;
}
.wpad {
	margin-bottom: 10px;
}

</style>
<% if(dto.getUser_no() == board_dto.getUser_no()) { %>
	<script type="text/javascript">
		alert("Authがございません。メインページに移動します。");
		location.href = "./FrontController?src=main";
	</script>
<% } %>
<div class="container top-margin-ss">
	<form action="modifyBoard.do" id="writefrm" method="post">
		<input type="hidden" value="<%=dto.getUser_no() %>" name="user_no" />
		<input type="hidden" value="<%=board_dto.getSs_no() %>" name="ss_no" />
		
		<input type="text" name="title" class="write-form-width" value="<%=board_dto.getTitle() %>" /><br />
		
		<textarea rows="2" class="write-form-width" name="writer_comment"><%=board_dto.getWriter_comment() %></textarea>
		<hr />
		<textarea rows="10" class="write-form-width" name="main_content"><%=board_dto.getMain_content() %></textarea>
		<hr />
		<input type="text" class="write-form-width wpad" placeholder="태그는 ,로 구분합니다." name="tags" />
		<button type="submit" class="btn btn-success">수정하기</button>
	</form>
</div>