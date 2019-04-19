<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<nav class="navbar navbar-dark bg-dark" role="navigation">
	<div class="nav-wrapper container">
		<a id="logo-container" href="#" class="brand-logo" style="font-size:30px;">EC</a>
		<div class="text-left">
			<% boolean isLogin = session.getAttribute("isLogin")!=null?(boolean) session.getAttribute("isLogin"):false; %>

			<%if(isLogin){ %>
			<a href="#"><button type="button" class="btn btn-light">詳細</button></a>
			<%}else{ %>
			<a href="NewUserServlet"><button type="button" class="btn btn-light">新規登録</button></a>
			<%} %>

			<a href="#"><button type="button" class="btn btn-warning"><i class="fas fa-shopping-cart"></i></button></a>

			<%if(isLogin){ %>
			<a href="#"><button type="button" class="btn btn-danger">ログアウト</button></a>
			<%}else{ %>
			<a href="LoginServlet"><button type="button" class="btn btn-primary">ログイン</button></a>
			<%} %>
			</div>
	</div>
</nav>