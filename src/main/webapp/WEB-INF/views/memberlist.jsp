<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	function memberviewAjax(mid){
		$.ajax({
			type: 'post',
			url: 'memberviewAjax',
			data: {'mid':mid},
			dataType: 'json',
			success: function(result){
				
				var output = "<table>";
				output += "<tr><th>ID</th> <th>PASSWORD</th> <th>NAME</th>";
				output += "<th>EMAIL</th></tr>";
				output += "<tr>";
				output += "<td>"+result.mid+"</td>";
				output += "<td>"+result.mpassword+"</td>";
				output += "<td>"+result.mname+"</td>";
				output += "<td>"+result.memail+"</td>";
				output += "</tr>";
				output += "</table>";
				
				document.getElementById('memberviewdiv').innerHTML = output; 
			},
			error: function(){
				comsole.log('문제발생');
			}
		});
		
	}
</script>

</head>
<body>
	<h2>memberlist.jsp</h2>
	
	로그인아이디: ${sessionScope.loginMember} <br>
	
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>상세조회</th>
			<th>삭제</th>
			<th>ajax로 상세조회</th>
		</tr>
		<c:forEach var="member" items="${memberList}">
			<tr>
				<td>${member.mid}</td>
				<td>${member.mpassword}</td>
				<td>${member.mname}</td>
				<td>${member.mphone}</td>
				<td>${member.memail}</td>
				<td><a href="memberview?mid=${member.mid}">조회</a></td>
				<td><a href="memberdelete?mid=${member.mid}">삭제</a></td>
				<td><button onclick="memberviewAjax('${member.mid}')">조회(ajax)</button></td>
			</tr>
		</c:forEach>
	</table>
	<div id="memberviewdiv"></div>
	<a href="./">홈으로</a>
	<a href="membermain">관리자 기능</a>
</body>
</html>