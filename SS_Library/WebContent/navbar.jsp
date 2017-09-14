<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%  %>

    <!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="./FrontController?src">JSL Novel</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<% if(session.getAttribute("user") != null) { %>
					<li>
						<a class="nav-link" href="./FrontController?src=write">글쓰기</a>
					</li>
					<% } %>
					<li class="nav-item active">
						<a class="nav-link" href="./FrontController?src">미리보기 모드
							<span class="sr-only">(current)</span>
						</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="./FrontController?src=board">게시판 모드</a>
					</li>
					<% if(session.getAttribute("user") != null) { %>
					<li class="nav-item">
						<a class="nav-link" href="./FrontController?src=modify">정보 수정</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="./FrontController?src=logout">로그아웃</a>
					</li>
					<% } else {%>
					<li class="nav-item">
						<a href = "" class="nav-link" data-toggle="modal" data-target="#loginmodal">로그인</a>
					</li>
					<% } %>
				</ul>
			</div>
		</div>
	</nav>
	
<style>
<!-- 

-->
body {
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #eee;
}

.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  height: auto;
  -webkit-box-sizing: border-box;
          box-sizing: border-box;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

</style>

	<div class="container">
		<div class="modal fade" id="loginmodal">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      	<div class="container">
			      <form class="form-signin" method="post" action="login.do">
			        <h2 class="form-signin-heading">JSL Novel</h2>
			        <label for="inputEmail" class="sr-only">Email address</label>
			        <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
			        <label for="inputPassword" class="sr-only">Password</label>
			        <input type="password" name="pass" id="inputPassword" class="form-control" placeholder="Password" required>
			        <div class="checkbox">
			          <label>
			            <input type="checkbox" name="remember" value="remember-me"> Remember me
			          </label>
			        </div>
			        <button class="btn btn-lg btn-outline-primary" type="submit">Sign in</button>
			        <button class="btn btn-lg btn-outline-info" onclick="location.href='./FrontController?src=join'">Register</button>
			      </form>
			    </div> <!-- /container -->
		    </div>
		  </div>
		</div>
	</div>
	
	