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
			success : function(result) {
				alert("메일이 발송되었습니다!!")
			},
			error : function(result) {
				alert("등록된 정보가 없습니다!!")
				location.href = "searchId";
			}
		})
	})
})