var main = {
    init: function () {
        var _this = this;

        // 버튼 클릭했을 때 일어날 함수 지정
        // $('btnId').on('click', function

    },
    // save버튼 누르면 db에 저장하기
    save: function () {
        var data = {
            // key: $('id').val(),
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert();
            window.location.href = '/';
        }).fail(function () {
            alert(JSON.stringify(error));
        })
    }
}


main.init();