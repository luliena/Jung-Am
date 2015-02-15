<!DOCTYPE HTML>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<title>Untitled Document</title>
</head>

<body>
<jsp:include page="../common/header.jsp" flush="false" />
<form action="#" method="post" name="join">
	<div>아이디</div><input type="text" name="id">
    <input type="button" value="ID중복검사"><br/>
    <div>비밀번호</div><input type="password" name="pw"><br/>
    <div>비밀번호 확인</div><input type="password" name="repw"><br/>
    <div>이메일</div><input type="text" name="email"><br/>
    <div>핸드폰</div>
    <select name="phone01">
    <option value="010">010</option>
    <option value="011">011</option>
    <option value="016">016</option>
    <option value="019">019</option>
    </select>
    -
    <input type="text" name="phone02" maxlength="4">
    -
    <input type="text" name="phone03" maxlength="4"><br/>
    <input type="button" value="가입">
    <input type="reset" value="취소">
    
</form>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
