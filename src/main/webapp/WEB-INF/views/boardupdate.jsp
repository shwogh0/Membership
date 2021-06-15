<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h2>boardupdate.jsp</h2>
	<form action="boardupdateprocess" method="post" name="updateform">
		글번호 : <input type="text" name="bnumber" id="bnb" value="${boardUpdate.bnumber}" readonly><br>
		제목 : <input type="text" name="btitle" value="${boardUpdate.btitle}"><br>
		작성자 : <input type="text" name="bwriter" value="${boardUpdate.bwriter}" readonly><br>
		내용 : <textarea rows="5" name="bcontents">${boardUpdate.bcontents}</textarea> <br>
		<br>
		<input type="submit"  value="수정">
	</form>
	
	
</body>
</html>