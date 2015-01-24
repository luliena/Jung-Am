<%@page import="com.jungam.manage.vo.NoticeVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show Notice</title>
</head>
<body>
	<%
		NoticeVO notice = (NoticeVO)request.getAttribute("noticeNode");
	%>
	
	<table width="500" height="300" border="1">
		<tr>
			<td width="33%" align="center">
				<label><%= notice.getIndex() %></label>
			</td>
			<td width="33%" align="center">
				<label><%= notice.getTitle().toString() %></label>
			</td>
			<td width="33%" align="center">
				<label><%= notice.getWriter().toString() %></label>
			</td>
			<td width="33%" align="center">
				<label><%= notice.getContent().toString() %></label>
			</td>	
			<td width="33%" align="center">
				<label><%= notice.getHitCount() %></label>
			</td>			
		</tr>
	</table>

</body>
</html>