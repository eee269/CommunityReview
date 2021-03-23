var main = {
    init: function () {
        var _this = this;
        $('#save_form').on('submit', function () {
            _this.save();
        });
        // $('#btn-save').on('click', function () {
        //     _this.save();
        // });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        })
    },
    save: function () {
        var content = $('textarea[name="content"]').val($('#summernote').summernote('code'));
        var data = {
            brd_title: $('#title').val(),
            brd_content: content,
            mem_nickname: $('#nickname').val(),
            mem_password: $('#password').val()
        };

        $.ajax({
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            data: JSON.stringify(data),
            url: '/api/board/save'
        }).done(function (brd_id) {
            alert('게시글이 저장되었습니다.');
            window.location.href = '/api/board/detail?brd_id=' + brd_id;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    },
    update: function () {
        var content = $('textarea[name="content"]').val($('#summernote').summernote('code'));
        var data = {
            brd_id: $('#brd_id').val(),
            brd_title: $('#title').val(),
            brd_content: content
        };

        $.ajax({
            type: 'PUT',
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            data: JSON.stringify(data),
            url: '/api/board/update'
        }).done(function (brd_id) {
            alert('수정완료 되었습니다.');
            window.location.href = '/api/board/detail?brd_id=' + brd_id;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    },
    delete: function () {
        var brd_id = $('#brd_id').val();

        if(confirm('정말 삭제하시겠습니까?')) {
            $.ajax({
                type: 'DELETE',
                contentType: 'application/json; charset=utf-8',
                url: '/api/board/delete/' + brd_id
            }).done(function () {
                alert('삭제가 완료되었습니다.');
                window.location.href='/board/';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            })
        } else return false;
    }
}