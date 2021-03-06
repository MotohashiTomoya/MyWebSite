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
<title>ユーザ削除</title>
</head>
<body>

	<jsp:include page="/baselayout/header.jsp" />
	<section class="jumbotron text-center">
		<div class="container">
			<h1>ユーザを削除しますか？</h1>
		</div>
	</section>
	<form class="form-signin" action="UserDeleteServlet" method="post">
	<div class="album py-5 bg-light">
			<div class="container">
			<div class="row">

			<input type="hidden" name="id" value="${user.id}">
			<div class="col s6 text-center">
						<button type="submit" class="btn btn-danger">はい</button>
					</div>
					<div class="col s6 text-center">
						<a class="btn btn-primary" href="UserListServlet" role="button">いいえ</a>
					</div>
					</div>
			</div>
		</div>
	</form>
</body>
</html>