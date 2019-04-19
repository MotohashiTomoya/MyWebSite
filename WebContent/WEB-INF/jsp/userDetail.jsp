<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
<link href="css/common.css" rel="stylesheet">
<title>ユーザ詳細</title>
</head>
<body>

	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Navbar</a>
	</nav>
	<!-- <jsp:include page="/baselayout/header.jsp" />jsp変更時にこれにする -->
	<section class="jumbotron text-center">
		<div class="container">
			<h1>ユーザ詳細</h1>
		</div>
	</section>
<form class="form-signin" action="UserDetailServlet" method="get">
<div class="album py-5 bg-light">
			<div class="container">
			<div class="row">
				<div class="col-6">ログインID</div>
				<div class="col-6">
					${user.loginId}
				</div>
			</div>
			<br>

			<div class="row">
				<div class="col-6">ユーザ名</div>
				<div class="col-6">
					${user.name}
				</div>
			</div>
			<br>

			<div class="row">
				<div class="col-6">登録日時</div>
				<div class="col-6">
					${user.createDate}
				</div>
			</div>
			<br>

			<div class="row">
				<div class="col-6">更新日時</div>
				<div class="col-6">
					${user.updateDate}
				</div>
			</div>
			<br>
			</div>
			</div>
			</form>
</body>
</html>