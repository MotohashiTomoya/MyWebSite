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
<title>商品一覧</title>
</head>

<body>
	<jsp:include page="/baselayout/header.jsp" />

	<section class="jumbotron text-center">
		<div class="container">
			<h1 class="jumbotron-heading">商品一覧</h1>
		</div>
	</section>
	<form action="ItemServlet" method="post">
		<div class="album py-5 bg-light">
			<div class="container">

				<div class="row center">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="商品名"
							name="name">

						<button type="submit" class="btn btn-primary">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
				<br> <br>
				<div class="row">
					<c:forEach var="item" items="${Item}">
						<div class="col-md-4">
							<div class="card mb-4">
								<div class="img-container--table-cell">
									<img class="card-img" src="img/${item.fileName}">
								</div>
								<div class="card-body">
									<p class="card-text">${item.name}</p>
									<div class="d-flex justify-content-between align-items-center">
										<a class="btn btn-primary"
											href="ItemDetailServlet?id=${item.id}">詳細</a> <small
											class="text-muted">${item.price}円</small>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

		</div>
	</form>

</body>
</html>