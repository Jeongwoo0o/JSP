$(function() {
	let st = 0;
	$("input:eq(1)").click(function() {
		let user 		= $('input[name="User"]').val();
    	st++;
	});
	
	$("input:eq(7)").click(function() {
		let user 		= $('input[name="User"]').val();
	    let pass 		= $('input[name="Pass"]').val();
	    let passCheck 	= $('input[name="Passcheck"]').val();
	    let name 		= $('input[name="Name"]').val();
	    let tel 		= $('input[name="Tel"]').val();
	    let addr 		= $('input[name="Addr"]').val();
	    
		if(st != 1) {
			alert("아이디 중복확인을 눌러주세요.");
			return false;
		}
		if(pass != passCheck){
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}
	});
	
    st = 0;

    return true;
});