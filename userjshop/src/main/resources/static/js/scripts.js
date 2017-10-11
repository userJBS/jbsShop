$(document).ready(function() {

	// 계정 삭제 처리
	$("#deleteAccount").click(deleteAccount);

	// 계정 생성 처리
	$("#createAccount").click(createAccount);

	// 댓글 등록
	// $("#createComments").click(createComments);

});

// 댓글 등록
function createComments(e) {
	// url 이동하지 못하도록 설정.
	e.preventDefault();

	// 폼에서 받아온 값
	var data = $('#comment').serialize();

	// 폼에서 설정한 url 주소
	var url = $("form").attr("action");

	console.log(data)

	// 요청 성공할경우
	var onSuccess = function(data) {
		if (data.state == true) {
			location.replace("/");
		} else {
			// data.state 상태가 false 일경우 에러 메시지로 출력
			$("#stateMessage").text(data.detailMessage).addClass(
					"alert alert-danger");
		}
	}

	$.ajax({
		url : url,
		type : "post",
		data : data,
		success : onSuccess
	});
}

// 계정 삭제 기능
function deleteAccount(e) {
	// url 이동하지 못하도록 설정.
	e.preventDefault();

	// 폼에서 받아온 password 값
	var data = $("#passwordValue").val();

	// 폼에서 설정한 url 주소
	var url = $("form").attr("action");

	// deleteAccount 함수의 요청이 성공할 경우.
	var onSuccess = function(data) {
		if (data.state == true) {
			location.replace("/");
		}

		// data.state 상태가 false 일경우 false 인 이유를 메시지로 출력
		$("#stateMessage").text(data.detailMessage).addClass(
				"alert alert-danger");
	}

	// 경고창으로 다시 한번 (확인/취소)
	if (confirm("정말로 탈퇴 하시겠습니까??")) {
		$.ajax({
			url : url,
			type : "delete",
			data : data,
			success : onSuccess
		});
	}
}

// 계정 생성 기능
function createAccount(e) {
	// url 이동하지 못하도록 설정.
	e.preventDefault();

	// 폼에서 받아온 값
	var data = $('#createForm').serialize();

	// 폼에서 설정한 url 주소
	var url = $("form").attr("action");

	// 요청 성공할경우
	var onSuccess = function(data) {
		if (data.state == true) {
			location.replace("/");
		} else {
			// data.state 상태가 false 일경우 에러 메시지로 출력
			$("#stateMessage").text(data.detailMessage).addClass(
					"alert alert-danger");
		}
	}

	$.ajax({
		url : url,
		type : "post",
		data : data,
		success : onSuccess
	});
}
