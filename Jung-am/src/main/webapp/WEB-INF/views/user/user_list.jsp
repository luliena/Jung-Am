<!DOCTYPE HTML>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<title>Untitled Document</title>
</head>

<body>
<jsp:include page="../common/header.jsp" flush="false" />
<table  width="400" height="15" border="1">
	<tr>
		<td> 이름 </td> <td> 아이디 </td> <td>이메일</td> <td>폰번호</td>
	</tr>
    <tr>
    	<td> 한혜준 </td> <td> hyejun </td> <td>hyejun223@naver.com</td> <td>010-4944-0232</td>
    </tr>
</table>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
