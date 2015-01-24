<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Untitled Document</title>
</head>

<body>
<jsp:include page="../common/header.jsp" flush="false" />
<form name="utility_make" method="post" action="#">
 <fieldset>
 <legend>공과금안내</legend>
제목 <input type="text" name="name" id="name" placeholder="제목을 입력"/></br></br>
파일첨부 : <input type="file" name="file"/></br></br>
<TEXTAREA name="message" rows="10" cols="70"></TEXTAREA></br></br>
공개설정 :  <input type="checkbox" name="public"/>전체보기
    	<input type="checkbox" name="public"/>비회원
   		<input type="checkbox" name="public"/>회원
    	<input type="checkbox" name="public"/>관리자</br></br>

 <input type="submit" value="완료"/> 
 &nbsp;&nbsp;&nbsp;
 <input type="reset" value="취소"/></p>  
 </fieldset>
</form>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
