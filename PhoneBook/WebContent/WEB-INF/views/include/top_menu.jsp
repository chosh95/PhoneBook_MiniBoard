<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='root' value='#{pageContext.request.contextPath }/'/>    
<!-- 게시판 상단 메뉴 -->
<nav class="navbar navbar-expand-md bg-info navbar-light shadow-lg">
    <a class="navbar-brand" href="${root }main">ChoBoard</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navMenu">
        <span class="navbar-toggler-icon"></span>        
    </button>
    <div class="collapse navbar-collapse" id="navMenu">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a href="${root }main" class="nav-link">번호검색</a>
            </li>
            <li class="nav-item">
                <a href="${root }main" class="nav-link">번호저장</a>
            </li>
        </ul>
        
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a href="${root}login" class="nav-link">로그인</a>
            </li>
        </ul>
    </div>
</nav>
