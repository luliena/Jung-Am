<!DOCTYPE HTML>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<title>Untitled Document</title>

<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.3.min.js"></script> 
<!--  <script type="text/javascript" src="/WEB-INF/js/jquery-2.1.3.js"></script> -->
	<script>
	$(document).ready(function () {
	 }
	</script>
</head>

<body>
	<jsp:include page="../common/header.jsp" flush="false" />
	
	<form name="login" action="checkLogin.do" onsubmit="#" method="post">
		아이디<input type="text" name="id" value="" style="height:30px; width:150px;"/><br/>
	    비밀번호<input type="password" name="password" value="" style="height:30px; width:150px;"/><br/>
		
		<input type="submit" name="" value="로그인" style="height:30px; width:100px;"/>
	</form>
	
	<a style="text-decoration:none;" href="주소">회원가입 |</a>
	<a style="text-decoration:none;" href="주소">아이디 찾기 |</a>
	<a style="text-decoration:none;" href="주소">비밀번호 찾기</a>
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>
