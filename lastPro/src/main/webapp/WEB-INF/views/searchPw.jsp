<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/memberStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#find").click(function() {
		alert("등록된 메일로 발송되었습니다!!")
	})
})
</script>
</head>
<body>
<form action="findPw">
<div class="search">
아이디 : <input type="text" name="id" class="searchIn"><br>
이름 : <input type="text" name="name" class="searchIn"><br>
<input type="submit" value="비밀번호 찾기" id="find">
</div>
</form>
</body>
</html>