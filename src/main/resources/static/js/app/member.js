var main = {
    init: function() {
        var _this = this;

        $('#btn-signup').on('click', function () {
            _this.signup();
        });

        $('#btn-signin').on('click', function () {
            _this.signin();
        });
    },
    signup: function () {
        var data = {
            mem_userid : $('#userid').val(),
            mem_password: $('#password').val(),
            mem_nickname: $('#nickname').val()
        };

        $.ajax({
            url: "/api/member/sign_up",
            dataType: 'json',
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
        }).done(function () {
            alert("회원가입이 완료되었습니다.");
            window.location.href='/member/sign_in';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    signin: function () {
        var data = {
            mem_userid: $('#userid').val(),
            mem_password: $('#password').val()
        };

        $.ajax({
            url: '/api/member/sign_in',
            dataType: 'json',
            type: 'GET',
            contentType: 'application/json; charset=utf-8',
            data: data
        }).done(function () {
            alert("로그인 되었습니다.");
            window.location.href='/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();