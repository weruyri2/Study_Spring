<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>	
</head>
<body>
	<h1>WEB-INF/view/board/regist.jsp</h1>
	
	<fieldset>
		<legend>글쓰기</legend>
		<form method="post"> 
		글제목 : <input type="text" name="title"> <br>
		작성자 : <input type="text" name="writer"> <br>
		내용 : <textarea rows="15" cols="10" name="content"></textarea> <br>		
		<input type="submit" value="글쓰기">
		</form>
	</fieldset>
	
	
	<%@ include file="../include/footer.jsp" %>	
</body>
</html>