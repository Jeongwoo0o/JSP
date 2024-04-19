$(function() {
	var user = $('input:eq(0)').val();
    var pass = $('input:nth-child(2)').val();
    var passCheck = $('input:nth-child(3)').val();
    var name = $('input:nth-child(4)').val();
    var tel = $('#input:nth-child(5)').val();
    var addr = $('input:nth-child(6)').val();
    alert(user);
    if (user.length < 5 || user.length > 10) {
        alert("아이디는 5자 이상, 10자 이하여야 합니다.");
        return false;
    }

    if (pass.length < 4) {
        alert("비밀번호는 4자 이상이어야 합니다.");
        return false;
    }

    if (pass !== passCheck) {
        alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        return false;
    }

    if (name.length > 5) {
        alert("이름은 5자 이내여야 합니다.");
        return false;
    }

    if (tel.length !== 11) {
        alert("전화번호는 11자리여야 합니다.");
        return false;
    }

    if (addr.length > 20) {
        alert("주소는 20자 이내여야 합니다.");
        return false;
    }

    return true;
});