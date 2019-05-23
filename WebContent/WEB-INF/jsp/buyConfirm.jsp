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
<title>購入確認</title>
</head>
<body>
	<jsp:include page="/baselayout/header.jsp" />

	<section class="jumbotron text-center">
		<div class="container">
			<h1 class="jumbotron-heading">商品を購入してよろしいですか？</h1>
		</div>
	</section>
	<form method="post" action="BuyConfirmServlet" class="form-horizontal">

		<div class="album py-5 bg-light">
			<div class="container">


				<hr>
				<table class="table table-bordered">
					<colgroup span="1" style="width: 350px;">
					<colgroup span="1" style="width: 70px;">
					<thead>
						<tr>
							<th class="text-center">商品名</th>
							<th class="text-center">小計</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cart" items="${cart}">
							<tr>
								<th class="text-center">${cart.name}</th>
								<th class="text-center">${cart.price}円</th>

							</tr>
						</c:forEach>
						<tr>
							<th class="text-center"></th>
							<th class="text-center"></th>

						</tr>

						<tr>
							<th class="text-center">合計</th>
							<th class="text-center">${total}円</th>

						</tr>
					</tbody>
				</table>
				<br> <br>
				<div class="row">
					<div class="col s6 text-center">
						<button type="submit" class="btn btn-primary">購入</button>
					</div>
					<div class="col s6 text-center">
						<a class="btn btn-info" href="ItemServlet">商品一覧に戻る</a>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>