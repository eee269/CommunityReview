var main = {
    init: function () {
        var _this = this;
        $('btn-save').on('click', function () {
            _this.save();
        });
    },
    save: function () {
        var data = {
            title: $('#brd_title').val(),
            content: $('#brd_content').val(),
            file: $('#brd_file').val(),
            image: $('#brd_image').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/board/save/', // session id 넘기는것 해결하기
            dataType: 'json',
            contentType: 'application/json; charset = utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};


main.init();