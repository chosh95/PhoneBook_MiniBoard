<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form" %>
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
		<form:form action="${root }phoneBook/insert_pro" method='post' modelAttribute="phoneBean">
			<div class="row">
				<div class="col-sm">
					<div class="card shadow">
						<div class="card-body">
							<p>전화번호 저장하기</p>
							<div class='form-group'>
								<form:label path="phone_name">이름</form:label>
								<form:input path='phone_name' class="form-control" />
								<form:errors path="phone_name" style='color:red'/>
							</div>
							<div class='form-group'>
								<form:label path="phone_number">전화번호</form:label>
								<form:input path='phone_number' class="form-control" />
								<form:errors path='phone_number' style='color:red'/>
							</div>
							<div class='form-group'>
								<form:label path="phone_month">생일 - 월</form:label>
								<form:input path='phone_month' class="form-control" />
								<form:errors path='phone_month' style='color:red'/>
							</div>
							<div class='form-group'>
								<form:label path="phone_day">생일 - 일</form:label>
								<form:input path='phone_day' class="form-control" />
								<form:errors path='phone_day' style='color:red'/>
							</div>
							<div class='form-group'>
								<form:label path="phone_memo">메모</form:label>
								<form:textarea path='phone_memo' class="form-control" />
							</div>
							<div class="form-group">
								<div class="text-right">
									<form:button class="btn btn-primary">저장하기</form:button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</div>

	<c:import url="/WEB-INF/views/include/bottom.jsp" />
</body>
</html>