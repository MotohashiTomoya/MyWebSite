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
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<link href="css/common.css" rel="stylesheet">
<title>カート</title>
</head>
<body>

  <jsp:include page="/baselayout/header.jsp" />
  <section class="jumbotron text-center">
    <div class="container">
<i class="fas fa-shopping-cart fa-7x"></i>
      <br>
</div>
<br><br>

<a class="btn btn-primary" href="#" role="button">レジに進む</a>
  </section>
<div class="album py-5 bg-light">
		<div class="container">
			<div class="row">
				<c:forEach var="buy" items="${buy}">
					<div class="col-md-4">
						<div class="card mb-4">
							<div class="img-container--table-cell">
								<img class="card-img" src="img/${buy.fileName}">
							</div>
							<div class="card-body">
								<p class="card-text">${buy.name}</p>
								<div class="d-flex justify-content-between align-items-center">
									<a class="btn btn-primary"href="CartDeleteServlet?id=${buy.id}">削除</a>
									<small class="text-muted">${buy.price}円</small>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

	</div>

</body>
</html>