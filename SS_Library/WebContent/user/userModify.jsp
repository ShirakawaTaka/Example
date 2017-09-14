<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ssl.dto.UserDTO" %>
<% UserDTO dto = (UserDTO) session.getAttribute("user"); %>
    
<script type="text/javascript">
function checkPass(){
	var pass1 = $('#pass').val();
	var pass2 = $('#pass2').val();
	if(pass1 == pass2) $('#passCheck').addClass('invisible');
	else {
		if($('#passCheck').hasClass('invisible')) $('#passCheck').removeClass('invisible');
	}
}

</script>

<h3 class="top-margin-ss" align="center">정보 관리</h3>
<div class="container">
	<div id="accordion" role="tablist" aria-multiselectable="true">
	  <div class="card">
	    <div class="card-header" role="tab" id="headingOne">
	      <h5 class="mb-0">
	        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
	          정보 수정
	        </a>
	      </h5>
	    </div>
	
	    <div id="collapseOne" class="collapse show padding-ss" role="tabpanel" aria-labelledby="headingOne">
	      <div class="card-block">
	     	<form action="modify.do" method="post">
	     		<input type="hidden" name="user_no" value="<%=dto.getUser_no() %>" />
	      		<div class="form-group row">
		      	  <label class="col-2 col-form-label">E-mail</label>
		      	  <div class="col-10">
					<input class="form-control" type="email" name="email" value="<%=dto.getEmail() %>" />
				  </div>
	      		</div>
	      		<div class="form-group row">
		      	  <label class="col-2 col-form-label">Password</label>
		      	  <div class="col-10">
					<input class="form-control" id="pass" type="password" name="password" onblur="checkPass();" placeholder="무조건 작성"/>
				  </div>
	      		</div>
	      		<div class="form-group row">
		      	  <label class="col-2 col-form-label">Password CK</label>
		      	  <div class="col-10">
					<input class="form-control" id="pass2" type="password" name="passwordCheck" onblur="checkPass();" placeholder="변경유무 관계없음"/>
				  </div>
				  <div id="passCheck" class="invisible col-10">비밀번호가 일치하지 않아요.</div>
	      		</div>
	      		<div class="form-group row">
		      	  <label class="col-2 col-form-label">NickName</label>
		      	  <div class="col-10">
					<input class="form-control" type="text" name="nickname" value="<%=dto.getNickname() %>" />
				  </div>
	      		</div>
	      		<div align="right">
	      			<button class="btn btn-danger">삭제하기</button>
	      			<button class="btn btn-default" type="submit" >수정하기</button>
	      		</div>
	     	</form>
	      </div>
	    </div>
	  </div>
	  <div class="card">
	    <div class="card-header" role="tab" id="headingTwo">
	      <h5 class="mb-0">
	        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
	          내가 쓴 글
	        </a>
	      </h5>
	    </div>
	    <div id="collapseTwo" class="collapse padding-ss" role="tabpanel" aria-labelledby="headingTwo">
	      <div class="card-block">
	        <div>
	        	<table class="table">
	        		<thead>
	        			<tr>
	        				<th>제목</th>
	        				<th>hit</th>
	        				<th>좋아요</th>
	        				<th></th>
	        			</tr>
	        		</thead>
	        		<tbody>
	        			<tr>
	        				<td>리틀데몬의 증거</td>
	        				<td>50</td>
	        				<td>50</td>
	        				<td>
	        					<button class="btn btn-default">수정</button>
	        					<button class="btn btn-default">삭제</button>
	        				</td>
	        			</tr>
	        			<tr>
	        				<td>천의 노래가 되어</td>
	        				<td>1000</td>
	        				<td>1000</td>
	        				<td>
	        					<button class="btn btn-default">수정</button>
	        					<button class="btn btn-default">삭제</button>
	        				</td>
	        			</tr>
	        			<tr>
	        				<td>다이아님의 정리해줘 박스</td>
	        				<td>100</td>
	        				<td>999</td>
	        				<td>
	        					<button class="btn btn-default">수정</button>
	        					<button class="btn btn-default">삭제</button>
	        				</td>
	        			</tr>
	        		</tbody>
	        	</table>
	        </div>
	      </div>
	    </div>
	  </div>
	  <div class="card">
	    <div class="card-header" role="tab" id="headingThree">
	      <h5 class="mb-0">
	        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
	          즐겨찾기 관리
	        </a>
	      </h5>
	    </div>
	    <div id="collapseThree" class="collapse padding-ss" role="tabpanel" aria-labelledby="headingThree">
	      <div class="card-block">
	      	이 부분에는<br /> 1. 즐겨찾는 태그 관리<br />
	      	2. 즐겨찾는 작가 관리 <br />
	      	두 가지의 관리 부분이 들어갈 예정.
	      </div>
	    </div>
	  </div>
	</div>
</div>