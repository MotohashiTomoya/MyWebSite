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
<title>ユーザ更新</title>
</head>
<body>

	<jsp:include page="/baselayout/header.jsp" />
	<section class="jumbotron text-center">
		<div class="container">
			<h1>ユーザ更新</h1>
		</div>
		<br>
		<c:if test="${errMsg != null}">
				<div class="alert alert-danger" role="alert">${errMsg}</div>
			</c:if>
	</section>
<form class="form-signin" action="UserUpdateServlet" method="post">
<div class="album py-5 bg-light">
			<div class="container">
			<div class="row">
				<div class="col-6">ログインID</div>
				<div class="col-6">${user.loginId}</div>
				<input type="hidden" name="loginId" value="${user.loginId}">
			</div>
			<br> <br> <input type="hidden" name="id" value="${user.id}">

			<div class="form-group row">
				<label for="password" class="col-sm-6 col-form-label">パスワード</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" id="password"
						placeholder="" name="password">
				</div>
			</div>
			<br>

				<div class="form-group row">
					<label for="password" class="col-sm-6 col-form-label">パスワード(確認)</label>
					<div class="col-sm-6">
						<input type="password" class="form-control" id="password1"
							placeholder="" name="passwordP">
					</div>
				</div>
				<br>
				<div class="form-group row">
					<label for="name" class="col-sm-6 col-form-label">ユーザ名</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="name"
							value="${user.name}" name="name">
					</div>
				</div>
				<br>

				<div class="text-center">
					<button type="submit" class="btn btn-primary">更新</button>

				</div>
				</div>
				</div>
			</form>
</body>
</html>