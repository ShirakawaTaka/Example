<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ssl.dto.UserDTO" %>
<% UserDTO dto = (UserDTO) session.getAttribute("user"); %>

<style>
.write-form-width {
	width : 100%;
}
.wpad {
	margin-bottom: 10px;
}

</style>

<div class="container top-margin-ss">
	<form action="write.do" id="writefrm" method="post">
		<input type="hidden" value="<%=dto.getUser_no() %>" name="user_no" />
		
		<input type="text" name="title" class="write-form-width" /><br />
		
		<textarea rows="2" class="write-form-width" name="writer_comment"></textarea>
		<hr />
		<textarea rows="10" class="write-form-width" name="main_content"></textarea>
		<hr />
		<input type="text" class="write-form-width wpad" placeholder="태그는 ,로 구분합니다." name="tags" />
		<button type="submit" class="btn btn-success">쓰기</button>
	</form>
</div>