<!DOCTYPE HTML>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<title>Untitled Document</title>
</head>

<body>
<jsp:include page="../common/header.jsp" flush="false" />
<h1>8~10평(중문)</h1>
<table width="400" height="15" border="1">
<tr>
	<td>
    번호
    </td>
    <td>
    제목
    </td>
    <td>
    작성자
    </td>
    <td>
    등록일
    </td>
</tr>
<tr>
	<td>
    1.1
    </td>
    <td>
    2.1
    </td>
    <td>
    3.1
    </td>
    <td>
    4.1
    </td>
</tr>
</table>
<ul>
<li><a href="#">1</a></li>
<li><a href="#">2</a></li>
<li><a href="#">3</a></li>
<li><a href="#">4</a></li>
<li><a href="#">5</a></li>
</ul>
<div class="writing"><a href="oneroom_make.jsp">글쓰기</a></div>
<div class="revise"><a href="#">수정</a></div>
<div class="delete"><a href="#">삭제</a></div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
