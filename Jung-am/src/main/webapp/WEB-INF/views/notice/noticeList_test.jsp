<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.jungam.manage.vo.NoticeVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Notice List</title>
</head>
<body>
	<%
		int listCount;
		
		//HashMap<Integer, NoticeVO> resultTableList = new HashMap<Integer, NoticeVO>();
		HashMap<Integer, NoticeVO> resultTableList = (HashMap<Integer, NoticeVO>) request.getAttribute("list");
	%>
	
	<table width="500" height="300" border="1">
	  <%
	    	if(resultTableList.size() > 0){
	    		Iterator<Integer> key = resultTableList.keySet().iterator();
	    		while(key.hasNext()) {
	    			NoticeVO notice = resultTableList.get(key.next());
	    %>
		<tr>
			<td width="33%" align="center">
				<%= notice.getIndex() %>
			</td>
			<td width="33%" align="center">
				<label><a href="shownotice/<%=notice.getIndex()%>.do"><%= notice.getTitle().toString() %></a></label>
			</td>
			<td width="33%" align="center">
				<%= notice.getWriter().toString() %>
			</td>
			<td width="33%" align="center">
				<%= notice.getContent().toString() %>
			</td>	
			<td width="33%" align="center">
				<%= notice.getHitCount() %>
			</td>			
		</tr>
	<%
			}
		}
	%>
	</table>

</body>
</html>