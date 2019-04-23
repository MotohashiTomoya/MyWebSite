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
			<br>
			<div class="row center">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="商品名">
					<form action="ItemServlet" action="post">
						<button type="submit" class="btn btn-primary"> <i
							class="fas fa-search"></i>
						</button>
					</form>
				</div>
			</div>

		</div>

	</section>

	<div class="album py-5 bg-light">
		<div class="container">

<div class="text-right"><a href="NewItemServlet">商品登録</a></div>


		</div>
	</div>


</body>
</html>