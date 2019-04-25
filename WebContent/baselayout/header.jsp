<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<nav class="navbar navbar-dark bg-dark" role="navigation">
	<div class="nav-wrapper container">
		<a id="logo-container" href="ItemServlet" class="brand-logo" style="font-size:30px;">EC</a>
		<div class="text-left">
<c:choose>
<c:when test="${userInfo.loginId==null}">
		<a href="NewUserServlet"><button type="button" class="btn btn-light">新規登録</button></a>
		<a href="CartServlet"><button type="button" class="btn btn-warning"><i class="fas fa-shopping-cart"></i></button></a>
		<a href="LoginServlet"><button type="button" class="btn btn-primary">ログイン</button></a>
</c:when>
<c:when test="${userInfo.loginId!=null}">
		<a href="UserDetailServlet?id=${userInfo.id}"><button type="button" class="btn btn-light">詳細</button></a>
		<a href="CartServlet"><button type="button" class="btn btn-warning"><i class="fas fa-shopping-cart"></i></button></a>
		<a href="LogoutServlet"><button type="button" class="btn btn-danger">ログアウト</button></a>
</c:when>
</c:choose>


			</div>
	</div>
</nav>