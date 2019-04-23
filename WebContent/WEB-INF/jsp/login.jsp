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
<title>ログイン画面</title>
</head>
<body>

	<jsp:include page="/baselayout/header.jsp" />


<section class="jumbotron text-center">
		<div class="container">
			<h1>ログイン</h1>
		</div>
		<br>
		<c:if test="${errMsg != null}">
			<div class="alert alert-danger" role="alert">${errMsg}</div>
		</c:if>
	</section>
	<div class="album py-5 bg-light">
		<div class="container">
		<div class="text-right"><a href="NewUserServlet">新規登録</a></div>
		<br><br>



				<form class="form-signin" action="LoginServlet" method="post">
					<input type="text" id="inputLoginId" class="form-control"
						placeholder="ログインID" name="loginId"> <br> <input
						type="password" id="inputPassword" class="form-control"
						placeholder="パスワード" name="password">
					<div class="text-center">
						<br> <br>
						<button type="submit" class="btn btn-primary">ログイン</button>
					</div>
				</form>

		</div>
</div>

</body>
</html>