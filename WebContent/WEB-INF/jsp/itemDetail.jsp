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
<title>商品詳細</title>
</head>
<body>

	<jsp:include page="/baselayout/header.jsp" />

	<section class="jumbotron text-center">
		<div class="container">
			<h1>${item.name}</h1>
		</div>
	</section>
	<div class="album py-5 bg-light">
		<div class="container">
			<div class="row">
				<div class="col s6">
					<img class="card-img" src="img/${item.fileName}">
				</div>
				<div class="col s6">
					<h3>${item.price}円</h3>
					<h5>${item.detail}</h5>
				</div>
			</div>
		</div>
		<br>
		<br>
		<div class="text-center">
			<form action="CartAddServlet" method="POST">
				<input type="hidden" name="itemId" value="${item.id}">
				<button class="btn waves-effect waves-light btn btn-primary"
					type="submit" name="action">
					カートに入れる<i class="fas fa-cart-plus"></i>
				</button>
			</form>

		</div>
	</div>
</body>
</html>