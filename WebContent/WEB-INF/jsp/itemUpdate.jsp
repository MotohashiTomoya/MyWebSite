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
<title>商品更新</title>
</head>
<body>


	<jsp:include page="/baselayout/header.jsp" />
	<section class="jumbotron text-center">
		<div class="container">
			<h1>商品更新</h1>
		</div>
		<br>
		<c:if test="${errMsg != null}">
			<div class="alert alert-danger" role="alert">${errMsg}</div>
		</c:if>
	</section>
	<form class="form-signin" action="ItemUpdateServlet" method="post" enctype="multipart/form-data">
		<div class="album py-5 bg-light">
			<div class="container">
				<div class="row">
					<div class="col-6">商品ID</div>
					<div class="col-6">${item.id}</div>
					<input type="hidden" name="itemId" value="${item.id}">
				</div>
				<br> <br>
				<div class="form-group row">
					<label for="itemName" class="col-sm-6 col-form-label">商品名</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="itemName"
							value="${item.name}" name="itemName">

					</div>
				</div>
				<br>
				<div class="form-group row">
					<label for="detail" class="col-sm-6 col-form-label">詳細</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="itemDetail"
							value="${item.detail}" name="itemDetail">
					</div>
				</div>

				<br>
				<div class="form-group row">
					<label for="price" class="col-sm-6 col-form-label">単価</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="itemPrice"
							value="${item.price}" name="itemPrice">
					</div>
				</div>
				<br>

				<div class="form-group row">
					<label for="image" class="col-sm-6 col-form-label">画像ファイル</label>
					<div class="col-sm-6">
						<input type="file" class="form-control" id="image"
						  name="image">
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