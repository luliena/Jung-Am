<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Untitled Document</title>
</head>

<body>
<form name="oneroom_make" method="post" action="#">
 <fieldset>
 <legend>원룸공실안내</legend>
제목 <input type="text" name="name" id="name" placeholder="제목을 입력"/></br></br>
공실선택 <!--<select name="select" multiple="multiple">-->
     <select name="select"> <!-- mutiple 속성 없으면 하나만 선택가능 -->
      <option value="1">8~10평</option>
      <option value="2">8~10평(중문)</option>
      <option value="3">5~7평</option>
      <option value="4">3~4평</option>
     </select></br></br>
임대료 <input type="text" name="name" id="name" placeholder="제목을 입력"/></br></br>
면적 <input type="text" name="name" id="name" placeholder="제목을 입력"/></br></br>
난방/전기 <input type="text" name="name" id="name" placeholder="제목을 입력"/></br></br>
주차 <input type="radio" name="parking"/>가능
	<input type="radio" name="parking"/>불가능</br></br>
입주가능날짜 <input type="date" name="bday"></br></br>
파일첨부 : <input type="file" name="file"/></br></br>
<TEXTAREA name="message" rows="10" cols="70"></TEXTAREA></br></br>
 <input type="submit" value="완료"/> 
 <input type="reset" value="취소"/></p>  
 </fieldset>
</form>
</body>
</html>
