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
<title>ユーザ詳細</title>
</head>
<body>

	<jsp:include page="/baselayout/header.jsp" />
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
					<div class="col-6">${user.loginId}</div>
				</div>
				<br>

				<div class="row">
					<div class="col-6">ユーザ名</div>
					<div class="col-6">${user.name}</div>
				</div>
				<br>

				<div class="row">
					<div class="col-6">登録日</div>
					<div class="col-6">${user.createDate}</div>
				</div>
				<div class=text-center>
					<br> <br>
					<div class="row">
						<div class="col s6 text-center">
							<a class="btn btn-success" href="UserUpdateServlet?id=${user.id}">更新</a>
						</div>
						<div class="col s6 text-center">
							<a class="btn btn-danger" href="UserDeleteServlet?id=${user.id}">削除</a>
						</div>
						<br>
					</div>
				</div>
				<br><br><br>
				<h3>購入履歴</h3>
				<br><br>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">商品名</th>
							<th scope="col">単価</th>
							<th scope="col">購入日時</th>
							<th scope="col">詳細</th>
						</tr>
					</thead>
					<tbody>
					<!-- 	<c:forEach var="buyd" items="${buyd}"> -->
							<tr>
								<td>${buyd.name}</td>
								<td>${buyd.price}</td>
								<td>${buyd.createDate}</td>
								<td class="text-center"><a class="btn btn-info"href="ItemDetailServlet?id=${buyd.item_id}"></a></td>
							</tr>
					<!--</c:forEach>  -->
					</tbody>
				</table>
			</div>
		</div>
	</form>
</body>
</html>