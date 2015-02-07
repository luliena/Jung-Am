<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.jungam.manage.vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.3.min.js"></script> 
<!--  <script type="text/javascript" src="/WEB-INF/js/jquery-2.1.3.js"></script> -->
<script>
	  $(document).ready(function () {
		  //alert('start!!');
		$('.writing').css('color', 'red');
		$(function(){
			$('.content').hide();
			$('.title').click(function(){
				if($(this).next().css('display') != 'none')
					$(this).next().slideUp(250);
				else {
					$('.content').slideUp(250);
					$(this).next().slideDown(250);
				}
			});
		});
	 });
</script>
	<title>Untitled Document</title>
</head>
<body>
<jsp:include page="../common/header.jsp" flush="false" />
<h1>공지사항</h1>
<table width="400" height="15" border="1">
<tr>
	<td>    번호    </td><td>    제목    </td><td>    작성자    </td><td>    등록일    </td>
</tr>
	<%
		int listCount;
			HashMap<Integer, BoardVO> resultTableList = (HashMap<Integer, BoardVO>) request.getAttribute("list");
			
			if(resultTableList.size() > 0){
			    		Iterator<Integer> key = resultTableList.keySet().iterator();
			    		while(key.hasNext()) {
			    			BoardVO notice = resultTableList.get(key.next());
	%>
				<tr class="title">
					<td>
				    <%=notice.getIndex() %>
				    </td>
				    <td>
				    <!-- <a href="notice/<%=notice.getIndex()%>.do"> -->
				    <%= notice.getTitle().toString() %></a>
				    </td>
				    <td>
				    <%= notice.getWriter().toString() %>
				    </td>
				    <td>
				    <%= String.valueOf(notice.getHitCount()) %>
				    </td>
				</tr>
				<tr class="content">
					<td colspan="4">
				    <%= notice.getContent().toString() %> <!--  need to change notice.getRegiDate().toString() -->
				    </td>
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
<div class="writing"><a href="noticeWrite.do">글쓰기</a></div>
<div class="revise"><a href="#">수정</a></div>
<div class="delete"><a href="#">삭제</a></div>

<%@ include file="../common/footer.jsp" %>
</body>
</html>
