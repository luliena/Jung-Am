<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.jungam.manage.vo.NoticeVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Untitled Document</title>
</head>
<body>
<jsp:include page="../common/header.jsp" flush="false" />
<h1>공지사항</h1>
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
	<%
		int listCount;
		HashMap<Integer, NoticeVO> resultTableList = (HashMap<Integer, NoticeVO>) request.getAttribute("list");
		
		if(resultTableList.size() > 0){
    		Iterator<Integer> key = resultTableList.keySet().iterator();
    		while(key.hasNext()) {
    			NoticeVO notice = resultTableList.get(key.next());
	%>
				<tr>
					<td>
				    <%=notice.getIndex() %>
				    </td>
				    <td>
				    <a href="shownotice/<%=notice.getIndex()%>.do"><%= notice.getTitle().toString() %></a>
				    </td>
				    <td>
				    <%= notice.getWriter().toString() %>
				    </td>
				    <td>
				    <%= notice.getContent().toString() %>
				    </td>
				    <!-- not hit count -->
				</tr>
	<%
			}
		}
	%>
</table>
<ul>
<li><a href="#">1</a></li>
<li><a href="#">2</a></li>
<li><a href="#">3</a></li>
<li><a href="#">4</a></li>
<li><a href="#">5</a></li>
</ul>
<div class="writing"><a href="notice_make.jsp">글쓰기</a></div>
<div class="revise"><a href="#">수정</a></div>
<div class="delete"><a href="#">삭제</a></div>

<%@ include file="../common/footer.jsp" %>
</body>
</html>
