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
<title>管理用商品一覧</title>
</head>
<body>

	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Navbar</a>
	</nav>
	<!-- <jsp:include page="/baselayout/header.jsp" />jsp変更時にこれにする -->
	<section class="jumbotron text-center">
		<div class="container">
			<h1>管理用商品一覧</h1>
		</div>
	</section>
	<form>

		<div class="album py-5 bg-light">
			<div class="container">
			<div class="text-right"><a href="#">商品新規登録</a></div>
			<br>
				<div class="form-group row">
					<label for="inputItem" class="col-sm-2 col-form-label">商品名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputItem"
							placeholder="">
					</div>
				</div>
				<div class="text-right">
					<a type="button" class="btn btn-outline-secondary">検索</a>

				</div>
				<hr>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>商品名</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>${item.name}</th>


							<td><a class="btn btn-primary"
												href="UserDetailServlet?id=${item.id}">詳細</a>
											<a class="btn btn-success"
												href="UserUpdateServlet?id=${item.id}">更新</a>
											<a class="btn btn-danger"
												href="UserDeleteServlet?id=${item.id}">削除</a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</form>

</body>
</html>