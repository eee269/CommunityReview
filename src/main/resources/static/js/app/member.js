var main = {
    init: function() {
        var _this = this;

        $('#btn-signup').on('click', function () {
            if($('#nickname').val() == "") {
                alert("닉네임을 입력하세요!");
                return false;
            } else if($('#mail_bool').val() == false) {
                alert("이메일을 확인하세요!");
                return false;
            } else if($('#pw_bool').val() == false) {
                alert("비밀번호를 확인하세요!");
                return false;
            } else _this.signup();
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
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert("로그인 되었습니다.");
            window.location.href='/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update: function () {
        var mem_id = $('#mem_id').val();
        var data = {
            mem_id: mem_id,
            mem_password: $('#password').val(),
            mem_nickname: $('#nickname').val()
        };

        $.ajax({
            data: JSON.stringify(data),
            url: '/api/member/update/' + mem_id,
            type: 'PUT',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
        }).done(function (data) {
            alert('수정되었습니다!');
            window.location.href = '/member/mypage?ses_id=' + data;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete: function () {
        var mem_id = $('#mem_id').val();
        if(confirm("정말 탈퇴를 원하시나요?")) {
            $.ajax({
                url: '/api/member/delete/' + mem_id,
                type: 'DELETE'
            }).done(function () {
                alert('다음에 또 봐요.. (´•̥ω•̥`) ');
                window.location.href='/';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        } else {
            return false;
        }
    }
};

main.init();