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
<title>新規商品</title>
</head>
<body>

	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Navbar</a>
	</nav>
	<!-- <jsp:include page="/baselayout/header.jsp" />jsp変更時にこれにする -->
	<section class="jumbotron text-center">
		<div class="container">
			<h1>商品新規登録</h1>
		</div>
	</section>
	<form class="form-signin" action="UserUpdateServlet" method="post">
		<div class="album py-5 bg-light">
			<div class="container">

				<div class="form-group row">
					<label for="itemName" class="col-sm-6 col-form-label">商品名</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="itemName"
							name="itemName">
					</div>
				</div>
				<br>

				<div class="form-group row">
					<label for="image" class="col-sm-6 col-form-label">画像</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="image" name="image">
					</div>
				</div>
				<br>
				<div class="form-group row">
					<label for="price" class="col-sm-6 col-form-label">単価</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="itemPrice"
							name="itemPrice">
					</div>
				</div>
				<br>
				<div class="form-group row">
					<label for="detail" class="col-sm-6 col-form-label">詳細</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="itemDetail"
							name="itemDateil">
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