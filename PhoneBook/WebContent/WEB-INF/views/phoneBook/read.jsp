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

	<div class="container" style="margin-top:100px">
            <div class="row">
                <div class="col-sm-2"></div>
                <div class="col-sm-9">
                    <div class="card shadow">
                        <div class="card-body">
                            <div class="form-group">
                                <label for="phone_name">이름</label>
                                <input type="text" id="phone_name" name="phone_name" class="form-control" value="${readPhoneBean.phone_name }" disabled="disabled"/>
                            </div>
                            <div class="form-group">
                                <label for="phone_number">전화번호</label>
                                <input type="text" id="phone_number" name="phone_number" class="form-control" value="${readPhoneBean.phone_number }" disabled="disabled"/>
                            </div>
                            <div class="form-group">
                                <label for="board_subject">생일</label>
                                <input type="text" id="phone_month" name="phone_month" class="form-control" value="${readPhoneBean.phone_month }월 ${readPhoneBean.phone_day}일" disabled="disabled"/>
                            </div>
                            <c:if test="${readPhoneBean.phone_memo != null }">
	                            <div class="form-group">
	                                <label for="phone_memo">메모</label>
	                                <textarea id="board_content" name="board_content" class="form-control" rows="10" style="resize:none" disabled="disabled">${readPhoneBean.phone_memo }</textarea>
	                            </div>
                            </c:if>
                            <div class="form-group">
                                <div class="text-right">
                                    <a href="${root }phoneBook/search" class="btn btn-primary">목록보기</a>
                                    <a href="${root }phoneBook/update?phone_idx=${readPhoneBean.phone_idx}" class="btn btn-info">수정하기</a>
                                    <a href="${root }phoneBook/delete?phone_idx=${readPhoneBean.phone_idx}" class="btn btn-danger">삭제하기</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3"></div>
            </div>
        </div>

	<c:import url="/WEB-INF/views/include/bottom.jsp" />
</body>
</html>