<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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

<div class = "container">
	<h1 class="my-4">계정 만들기</h1>
	<form action="join.do" method="post" id="joinfm">
		<div class="form-group row">
		  <label for="example-text-input" class="col-2 col-form-label">E-mail</label>
		  <div class="col-9">
		    <input class="form-control" type="email" name="email" placeholder="ID로 사용할 이메일 주소" required autofocus/>
		    <button class="btn btn-warning btn-sm" onclick="">중복 확인</button>
		  </div>
		</div>
		<div class="form-group row">
		  <label for="example-text-input" class="col-2 col-form-label">Password</label>
		  <div class="col-9">
		    <input class="form-control" type="password" name="pass" id="pass" placeholder="비밀번호" onblur="checkPass();" required/>
		    <input class="form-control" type="password" name="pass2" id="pass2" placeholder="비밀번호 확인" onblur="checkPass();" />
		    <div id="passCheck" class="invisible">비밀번호가 일치하지 않아요.</div>
		  </div>
		</div>
		<div class="form-group row">
		  <label for="example-text-input" class="col-2 col-form-label">Nick Name</label>
		  <div class="col-9">
		    <input class="form-control" type="text" name="nickname" placeholder="닉네임은 12자까지" required pattern="{1, 12}"/>
		  </div>
		</div>
		<input type="submit" class="btn btn-default" value="가입하기" />
		<input type="reset" class="btn btn-danger" value="다시쓰기" />
	</form>
</div>
