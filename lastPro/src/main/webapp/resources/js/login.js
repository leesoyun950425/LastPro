// 아이디 내용이 없을때 처리.
$(function() {
	$("#find").click(function() {
		var name = $("#name").val();
		var email = $("#email").val();
		$.ajax({
			url : "findId",
			data : {
				"name" : name,
				"email" :email
			},
			success : function() {
				alert("메일이 발송되었습니다!!")
			},
			error : function() {
				alert("등록된 정보가 없습니다!!")
				location.href = "searchId";
			}
		})
	})
	
	$("#findPw").click(function() {
		var id = $("#id").val();
		var name = $("#name").val();
		$.ajax({
			url : "findPw",
			data : {
				"id" : id,
				"name" : name
			},
			success : function() {
				alert("등록된 메일로 발송했습니다!!")
			},
			error : function() {
				alert("등록된 정보가 없습니다!!")
				location.href = "searchPw";
			}
			
		})
	})
})