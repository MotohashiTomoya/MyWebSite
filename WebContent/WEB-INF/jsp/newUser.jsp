<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>新規登録</title>
</head>
<body>


	<jsp:include page="/baselayout/header.jsp" />
	<section class="jumbotron text-center">
		<div class="container">
			<h1>ユーザ新規登録</h1>
		</div>
		<br>
		<c:if test="${errMsg != null}">
			<div class="alert alert-danger" role="alert">${errMsg}</div>
		</c:if>
	</section>
	<form class="form-signin" action="NewUserServlet" method="post">
		<div class="album py-5 bg-light">
			<div class="container">
				<div class="form-group row">
					<label for="inputPassword" class="col-sm-6 col-form-label">ログインID</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="loginId"
							placeholder="" name="loginId">
					</div>
				</div>
				<br>

				<div class="form-group row">
					<label for="inputPassword" class="col-sm-6 col-form-label">パスワード</label>
					<div class="col-sm-6">
						<input type="password" class="form-control" id="password"
							placeholder="" name="password">
					</div>
				</div>
				<br>

				<div class="form-group row">
					<label for="inputPassword" class="col-sm-6 col-form-label">パスワード(確認)</label>
					<div class="col-sm-6">
						<input type="password" class="form-control" id="password1"
							placeholder="" name="password1">
					</div>
				</div>
				<br>

				<div class="form-group row">
					<label for="inputPassword" class="col-sm-6 col-form-label">ユーザ名</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="name" placeholder=""
							name="name">
					</div>
				</div>
				<br>
				<div class="text-center">
					<button type="submit" class="btn btn-primary">登録</button>

				</div>
			</div>
		</div>
	</form>
</body>
</html>