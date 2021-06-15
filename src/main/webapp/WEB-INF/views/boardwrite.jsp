<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>boardwrite.jsp</h2>
	
	로그인아이디: ${sessionScope.loginMember}
	
	<form action="boardwritefile" method="post" enctype="multipart/form-data">
		
		제목 : <input type="text" name="btitle"><br>
		작성자 : <input type="text" value="${sessionScope.loginMember}" name="bwriter"><br>
		내용 : <textarea name="bcontents" row="5"></textarea><br>
		파일 : <input type="file" name="bfile"><br>
		
		<input type="submit" value="작성"><br>
	</form>
</body>
</html>