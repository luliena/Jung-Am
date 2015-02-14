<!DOCTYPE HTML>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<title>Untitled Document</title>
</head>

<body>
<jsp:include page="../common/header.jsp" flush="false" />
<table width="600" height="600" border="1">
	<tr>
    	<td colspan="2" align="center">회원가입</td>
    </tr>
    <tr>
    	<th>아이디</th>
        <td><input type="text" name="id">
        <input type="button" name="idbutton" value="중복확인">
        </td>
    </tr>
    <tr>
    	<th>비밀번호</th>
        <td><input type="password" name="password"></td>
    </tr>
    <tr>
    	<th>비밀번호 재입력</th>
        <td>
        <input type="password" name="repassword"></td>
    </tr>
     <tr>
    	<th>이름</th>
        <td>
        	<form>
            	<select size="1" name="phone1">
                <option selected value="010">010</option>
                <option value="011">011</option>
                <option value="016">016</option>
                <option value="017">017</option>
                <option value="019">019</option>
                </select>
                -
                <input type="text" name="phone2" size="10" maxlength="20">
                -
                <input type="text" name="phone3" size="10" maxlength="20">
            </form>
        </td>
    </tr>
    <tr>
    	 <th style="text-align: center;">e-mail</th>
              <td><input type="text" name="email" style="width: 80px" onblur="checkid()">
               @ 
               <input type="text" name="e_domain" style="width: 80px">
               <select name="domain" onchange="domainCheck();">
                	<option value="0" selected="selected">직접입력</option>
                	<option value="naver.com">naver.com</option>
                	<option value="hanmail.net">hanmail.net</option>
                	<option value="nate.com">nate.com</option>
                	<option value="yahoo.com">yahoo.com</option>
               </select>
              </td>
          </tr>
 </table>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
