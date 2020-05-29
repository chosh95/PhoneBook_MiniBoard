<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='root' value='#{pageContext.request.contextPath }/'/>    
<!-- 게시판 상단 메뉴 -->
<nav class="navbar navbar-dark bg-primary navbar-expand-sm">

	<a class="navbar-brand " href="${root }main">ChoBoard</a>
    
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navMenu">
        <span class="navbar-toggler-icon"></span>        
    </button>
    
    <div class="collapse navbar-collapse" id="navMenu">
    	
        <ul class="navbar-nav ml-auto">
        	<c:choose>
        		<c:when test="${loginUserBean.isLogin() != true}">
		            <li class="nav-item">
		                <a href="${root}user/naverLogin" class="nav-link">로그인</a>
		            </li>
	            </c:when>
	            <c:otherwise>
		            <li class="nav-item">
		                <a href="${root}user/logout" class="nav-link">로그아웃</a>
		            </li>
	            </c:otherwise>
            </c:choose>
        </ul>
    </div>
    
    
</nav>
