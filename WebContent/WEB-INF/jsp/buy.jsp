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
<title>購入</title>
</head>
<body>

	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Navbar</a>
	</nav>
	<!-- <jsp:include page="/baselayout/header.jsp" />jsp変更時にこれにする -->
	<section class="jumbotron text-center">
		<div class="container">
			<h1>購入確認</h1>
		</div>
	</section>
	<form action="#" method="POST">
		<div class="album py-5 bg-light">
			<div class="container">

				<table class="table">
					<thead>
						<tr>
							<th scope="col">商品名</th>
							<th scope="col">単価</th>
							<th scope="col">小計</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">${item.name}</th>
							<td>${item.price}</td>
							<td>${item.price}</td>
						</tr>
					</tbody>
				</table>
				<br> <br>
				<table class="table">
					<thead>
						<tr>
							<th class="text-center">合計金額</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="text-center">allprice</td>
						</tr>
					</tbody>
				</table>
				<br>
				<br>
				<div class="row">
					<div class="col s12">
						<button class="btn  waves-effect waves-light  col s4 offset-s4"
							type="submit" name="action">購入</button>
					</div>
				</div>

			</div>
		</div>
	</form>
</body>
</html>