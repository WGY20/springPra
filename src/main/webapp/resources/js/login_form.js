$(document).ready(function() {
	$("#btn_login").on("click", function() {
		if ($("#a_id").val().trim() == "") {
			alert("INPUT ADMIN ID");
			$("#a_id").focus();
		} else if ($("#a_password").val().trim() == "") {
			alert("INPUT ADMIN PASSWORD");
			$("#a_password").focus();
		} else {
			$("#login_form").submit();
		}
	});
})