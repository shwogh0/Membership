<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		table,tr,th,td {
			border: 1px solid black;
			border-collapse: collapse;
		}
	</style>
</head>
<body>
	<h2>boardlist.jsp</h2>
	로그인아이디: ${sessionScope.loginMember} <br>
	
	<table>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
		</tr>
		<c:forEach var="board" items="${boardList}">
			<tr>
				<td>${board.bnumber}</td>
				<td>${board.bwriter}</td>
				<td><a href="boardview?bnumber=${board.bnumber}">${board.btitle}</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="writepage">글쓰기화면</a>
	<a href="./">홈으로</a>
	
	<c:if test="${!empty sessionScope.loginMember}">
		<a href="memberupdate?mid=${member.mid}">마이페이지수정</a>
	</c:if>
	
</body>
</html>