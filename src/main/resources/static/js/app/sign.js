var main = {
    init: function () {
        var _this = this;

        // 버튼 클릭했을 때 일어날 함수 지정
        $('#btn-signUp').on('click', function () {
            _this.signUp();
        });

        $('#btn-signIn').on('click', function () {
            _this.signIn();
        })

    },
    // save버튼 누르면 db에 저장하기
    signUp: function () {
        var data = {
            mem_userid: $('#userid').val(),
            mem_password: $('#password').val(),
            mem_username: $('#username').val(),
            mem_nickname: $('#nickname').val(),
            mem_phone: $('#phone').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/member/signUp',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('회원가입이 완료되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }, signIn: function () {
        var data = {
            mem_userid: $('#userid').val(),
            mem_password: $('#password').val()
        };

        var userid = $('#userid').val();

        $.ajax({
            type: 'POST',
            url: '/api/member/signIn/' + userid,
            dataType: 'text',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('로그인이 완료되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};


main.init();