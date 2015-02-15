<!DOCTYPE HTML>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<title>Untitled Document</title>
</head>

<body>
<jsp:include page="../common/header.jsp" flush="false" />

<%
	String message = (String)request.getAttribute("message");
	if(message != null) {
	%>
		<h3><%= message %></h3>   <!-- 로그인 실패 시, 나타나는 메세지 --> 
	<%
	}
%>
<form action="checkLogin.do" onsubmit="#" method="post">
	아이디<input type="text" name="id" value="" style="height:30px; width:150px;"/><br/>
    비밀번호<input type="password" name="password" value="" style="height:30px; width:150px;"/><br/>
    
  <input type="submit" name="" value="로그인" style="height:30px; width:100px;"/>
</form>

<a style="text-decoration:none;" href=""registerUser.do"">회원가입 |</a>
<a style="text-decoration:none;" href="주소">아이디 찾기 |</a>
<a style="text-decoration:none;" href="주소">비밀번호 찾기</a>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
