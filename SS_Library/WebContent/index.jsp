<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String pageindex = null;
if(request.getAttribute("pageindex") != null)
{
	pageindex = (String) request.getAttribute("pageindex");
} else pageindex = "./main/previewMode.jsp";

%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Novel Library</title>

	<!-- Bootstrap core CSS -->
	<link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">

	<!-- Custom styles for this template -->
	<link href="css/blog-home.css" rel="stylesheet">
	

	<!-- Bootstrap core JavaScript 
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script> -->

</head>

<body>
	<!-- Navigation -->
	<jsp:include page = "./navbar.jsp"></jsp:include>

	<!-- Page Content -->
	<div class="container">
		<div class="row">
		
			<!-- Blog Entries Column -->
	        <div class="col-md-8">
				<jsp:include page = "<%=pageindex %>"></jsp:include>
			</div><!-- main end -->
			
			<!-- Sidebar Widgets Column -->
			<div class="col-md-4">
				<jsp:include page = "./sidebar.jsp"></jsp:include>
			</div><!-- Sidebar end -->
			
		</div><!-- row end -->
	</div><!-- container end -->
	
	

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">JSL 25th Individual Project<br />
        Copyright &copy; Your Website 2017</p>
      </div>
      <!-- /.container -->
    </footer>

		 <!-- Bootstrap core JavaScript  -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

  </body>

</html>