<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>boardview.jsp</h2>
	현재 로그인 : ${sessionScope.loginMember} <br><br>
	글번호: ${board.bnumber}<br>
	제목: ${board.btitle}<br>
	작성자: ${board.bwriter}<br>
	내용: ${board.bcontents}<br>
	첨부파일: ${board.bfilename}<br>
	이미지: <img src="resources/upload/${board.bfilename}" height="200" width="200"> <br>
	<a href="boardlist">목록으로 돌아가기</a> <br>
	

	<c:if test="${sessionScope.loginMember eq board.bwriter}">
		<a href="boardupdate?bnumber=${board.bnumber}">수정</a>
	</c:if>
	
	
	<c:if test="${sessionScope.loginMember eq board.bwriter or $sessionScope.loginMember eq admin}">
	<a href="boarddelete?bnumber=${board.bnumber}">삭제</a><br>		
	</c:if>
	
	
	<a href="paging?page=${page}">페이징목록으로 돌아가기</a>

	<br><br><br>

	<div id="comment-write">
		작성자: <input type="text" value="${sessionScope.loginMember}" id="cwriter"><br>
		내용: <input type="text" id="ccontents"><br>
		<button id="cwrite-btn">댓글등록</button>
	</div>
	
<br><br><br>
	<div id="comment-list">
		<table border="1">
			<tr>
				<th>작성자</th>
				<th>내용</th>
			</tr>
			<c:forEach var="comment" items="${commentList}">
				<tr>
					<td>${comment.cwriter}</td>
					<td>${comment.ccontents}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(document).ready(function(){
		$("#cwrite-btn").click(function(){
			var cwriter = document.getElementById('cwriter').value;
			var ccontents = document.getElementById('ccontents').value;
			var cbnumber = '${board.bnumber}';
			console.log(cwriter);
			console.log(ccontents);
			console.log(cbnumber);
			$.ajax({
				type: 'post',
				url: 'comment/commentwrite',
				data:{
					'cwriter': cwriter,
					'ccontents': ccontents,
					'cbnumber': cbnumber},
				dataType: 'json',
				success: function(list){
					console.log(list);
					var output = "<table border='1'>";
					output += "<tr><th>작성자</th>";
					output += "<th>내용</th></tr>";
					for(var i in list){
						output += "<tr>";
						output += "<td>"+list[i].cwriter+"</td>";
						output += "<td>"+list[i].ccontents+"</td>";
						output += "</tr>";
					}
					output += "</table>";
					document.getElementById('comment-list').innerHTML = output;
					document.getElementById('cwriter').value='';
					document.getElementById('ccontents').value='';
				},
				error: function(){
					console.log('문제있음.');
				}
			});
		});
	});

</script>

	
</body>
</html>










