var main = {
    init: function () {
        var _this = this;

        $('#rep_cancel').on('click', function () {
            _this.write_cancel();
        });

        $('#rep_save').on('click', function () {
            _this.reply_save();
        });
    },
    write_cancel: function() {
        // 댓글 내용 초기화
        $('#rep_content').val('');
    },
    reply_save: function () {
        var session = $('#session').val();

        var data = {
            mem_nickname: $('#mem_nickname').val(),
            rep_content: $('#rep_content').val(),
            rep_parent: null,
            brd_id: $('#rep_brd_id').val(),
            mem_id: session
        };

        $.ajax({
            type: 'POST',
            url: '/api/board/reply/save/' + session,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('댓글 작성에 성공했습니다.');
            location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    },
    rep_update: function () {

    },
    rep_del: function () {

    },
    rep_open: function () {

    },
    rep_save: function (rep_id) {
        data = {
            mem_nickname: $('#mem_re_nickname').val(),
            rep_content: $('#rep_re_content').val(),
            rep_parent: rep_id,
            brd_id: $('#rep_brd_id').val(),
            mem_id: session
        };

        $.ajax({
            type: 'POST',
            url: '/api/board/reply/save/' + session,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('대댓글 작성에 성공했습니다.');
            location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    },
};

main.init();