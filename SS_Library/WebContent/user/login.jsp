<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


		<div class="loginmodal" id="loginmodal" role="dialog">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      	<div class="container">
			      <form class="form-signin" method="post" action="login.do">
			        <h2 class="form-signin-heading">JSL Novel</h2>
			        <label for="inputEmail" class="sr-only">Email address</label>
			        <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
			        <label for="inputPassword" name="pass" class="sr-only">Password</label>
			        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
			        <div class="checkbox">
			          <label>
			            <input type="checkbox" name="remember" value="remember-me"> Remember me
			          </label>
			        </div>
			        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			      </form>
			    </div> <!-- /container -->
		    </div>
		  </div>
		</div>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>