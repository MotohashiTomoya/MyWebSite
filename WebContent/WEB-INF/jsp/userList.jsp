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
<title>ユーザ一覧</title>
</head>
<body>


	<jsp:include page="/baselayout/header.jsp" />
	<section class="jumbotron text-center">
		<div class="container">
			<h1>ユーザ一覧</h1>
		</div>
	</section>
	<form method="post" action="UserListServlet" class="form-horizontal">
		<div class="album py-5 bg-light">
			<div class="container">
				<div class="form-group row">
					<label for="loginId" class="col-sm-2 col-form-label">ログインID</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="loginid"
							placeholder="" name="loginId">
					</div>
				</div>
				<div class="form-group row">
					<label for="name" class="col-sm-2 col-form-label">ユーザ名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="name" placeholder=""
							name="name">
					</div>
				</div>


				<div class="text-right">
					<button type="submit" class="btn btn-dark">検索</button>

				</div>
				<hr>
				<table class="table table-bordered">
					<colgroup span="2" style="width: 275px;">
					<colgroup span="1" style="width: 115px;">
					<thead>
						<tr>
							<th>ログインID</th>
							<th>ユーザ名</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${userList}">
							<tr>
								<th scope="row">${user.loginId}</th>
								<td>${user.name}</td>

								<td><a class="btn btn-primary"
									href="UserDetailServlet?id=${user.id}">詳細</a> <a
									class="btn btn-success" href="UserUpdateServlet?id=${user.id}">更新</a>
									<a class="btn btn-danger"
									href="UserDeleteServlet?id=${user.id}">削除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</form>


</body>
</html>