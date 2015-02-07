<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.jungam.manage.vo.BoardVO"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.3.min.js"></script> 
	<script>
	  $(function() {
		  <!-- $( "#tabs" ).tabs(); -->
	  });
	  
	  $(document).ready(function() {
			// 버튼이벤트 등록
		  //$("#auditFileSrchBtn").on("click", auditFileSrch);
			alert("start!!");
	  }
	</script>
<title>Untitled Document</title>
</head>

<body>
	<jsp:include page="../common/header.jsp" flush="false" />
	<form name="notice_make" method="post" onsubmit="#">
	 <fieldset>
	 <legend>공지사항</legend>
	 	<%
	 	BoardVO notice = (BoardVO)request.getAttribute("noticeNode");
	 	%>
	제목 <input type="text" name="name" id="name" placeholder=<%= notice.getTitle().toString() %>/></br></br>
	파일첨부 : <input type="file" name="file"/></br></br>
	<TEXTAREA name="message" rows="10" cols="70"placeholder=<%= notice.getContent().toString() %>></TEXTAREA></br></br>
	공개설정 :  <input type="checkbox" name="public"/>전체보기
	    	<!-- <input type="checkbox" name="public"/>비회원 -->  <!-- 비회원만 보는 게시물은 없을 듯 -->
	   		<input type="checkbox" name="public"/>회원
	    	<input type="checkbox" name="public"/>관리자</br></br>
	
	 <input type="submit" value="저장""/> 
	 &nbsp;&nbsp;&nbsp;
	 <input type="reset" value="취소" onclick="#"/></p>  
	 </fieldset>
	</form>
	<%@ include file="../common/footer.jsp" %>
	</body>
</html>
