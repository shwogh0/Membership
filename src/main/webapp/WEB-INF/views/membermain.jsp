<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

	function logout() {
		location.href="logout";
	}
	function update() {
		location.href="memberupdate";
	}
</script>

</head>
<body>
	<h2>membermain.jsp</h2>
	
	로그인아이디: ${sessionScope.loginMember} <br>
	
	<div style="background-color:yellow;">
	<a href="memberlist">회원목록조회</a>
	</div>
	
	<button onclick="logout()">로그아웃</button> <br>
	<button onclick="update()">회원정보수정</button> <br>
	<a href="./">홈으로</a>
</body>
</html>