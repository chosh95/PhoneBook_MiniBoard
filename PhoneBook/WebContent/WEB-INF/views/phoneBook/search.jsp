<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ChoBook</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
	<c:import url="/WEB-INF/views/include/top_menu.jsp" />

	<div class="container" style="margin-top: 100px; margin-bottom: 100px">
		<div class="row">
			<div class="col-md" style="margin-top: 20px">
				<div class="card shadow">
					<div class="card-body">
						<h4 class="card-title">전화번호 목록</h4>
						<table class="table table-hover" id='board_list'>
							<thead>
								<tr>
									<th class="text-center w-25">이름</th>
									<th class="text-center w-25">전화번호</th>
									<th class="text-center w-25">생일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var='obj' items="${list }">
									<tr>
										<td class="text-center">${obj.phone_name }</td>
										<td class="text-center"><a href="${root}phoneBook/read?phone_idx=${obj.phone_idx}">${obj.phone_number }</a></td>
										<td class="text-center">${obj.phone_month }월 ${obj.phone_day}일</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<c:import url="/WEB-INF/views/include/bottom.jsp" />
</body>
</html>