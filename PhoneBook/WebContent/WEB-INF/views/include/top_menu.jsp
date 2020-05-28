<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='root' value='#{pageContext.request.contextPath }/'/>    
<!-- �Խ��� ��� �޴� -->
<nav class="navbar navbar-dark bg-primary navbar-expand-sm">

	<a class="navbar-brand " href="${root }main">ChoBoard</a>
    
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navMenu">
        <span class="navbar-toggler-icon"></span>        
    </button>
    
    <div class="collapse navbar-collapse" id="navMenu">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a href="${root}user/naverLogin" class="nav-link">�α���</a>
            </li>
            <li class="nav-item">
                <a href="${root}user/logout" class="nav-link">�α׾ƿ�</a>
            </li>
        </ul>
    </div>
</nav>
