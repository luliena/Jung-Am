<%@page import="com.jungam.manage.vo.NoticeListVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	   int listCount;
	
		ArrayList<NoticeListVO> resultTableList = new ArrayList<NoticeListVO>();
		resultTableList = (ArrayList<NoticeListVO>)request.getAttribute("list");
		
		if(resultTableList == null) {
			listCount =0;
		} else {
			listCount = resultTableList.size();
		}
	%>
	
	<table width="500" height="300" border="1">
	  
	    <%
			if(listCount > 0){
				for(int i=0; i<listCount; i++){
					NoticeListVO notice = resultTableList.get(i);
		%>
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
	<%
			}
		}
	%>

</body>
</html>