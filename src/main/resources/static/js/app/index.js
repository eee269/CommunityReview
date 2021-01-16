var main = {
    init: function () {
        var _this = this;

        // 버튼 클릭했을 때 일어날 함수 지정
        $('#btn-signUp').on('click', function () {
            _this.signUp();
        });

    },
    // save버튼 누르면 db에 저장하기
    signUp: function () {
        var data = {
            userid: $('#userid').val(),
            password: $('#password').val(),
            username: $('#username').val(),
            nickname: $('#username').val(),
            phone: $('#phone').val()
        };

        $.ajax({
            type: 'POST',
            url: '/member/signUp',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('회원가입이 완료되었습니다.');
            window.location.href = '/';
        }).fail(function () {
            alert(JSON.stringify(error));
        });
    }
};


main.init();