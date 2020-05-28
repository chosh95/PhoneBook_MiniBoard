<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>ChoBook</title>
	<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
	<c:import url="/WEB-INF/views/include/top_menu.jsp" />

	<div class="container" style="margin-top:100px; margin-bottom:100px">
		<div class="col-sm text-center">
			<a href="${root }phoneBook/search"><img src="${root }/img/searchIcon.png" height="150px"><br>전화번호 조회/검색</a>
		</div>
		<div class="col-sm text-center" style="margin-top:30px">
			<a href="${root }phoneBook/insert"><img src="${root }/img/phonePlusIcon.png" height="150px"><br>전화번호 추가</a>
		</div>
	</div>

	<c:import url="/WEB-INF/views/include/bottom.jsp" />
</body>
</html>