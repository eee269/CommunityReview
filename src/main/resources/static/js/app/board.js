var main = {
    init: function () {
        var _this = this;

        $('#btn-save').on('click', function () {
            _this.save();
        });
        $('#btn-update').on('click', function () {
            _this.update();
        });
        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    save: function () {
        var ses_id = $('#session').val();

        var data = {
            brd_title: $('#brd_title').val(),
            brd_content: $('#summernote').summernote('code'),
            mem_id: ses_id,
            mem_nickname: $('#mem_nickname').val()

            // file: $('#brd_file').val(),
            // image: $('#brd_image').val()
        };


        $.ajax({
            type: 'POST',
            url: '/api/board/save/' + ses_id,
            dataType: 'json',
            contentType: 'application/json; charset = utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/board/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }, update: function () {
        var brd_id = $('#brd_id').val();

        var data = {
            // brd_category: $('#brd_category').val(),
            brd_title: $('#brd_title').val(),
            brd_content: $('#summernote').summernote('code')
        };
        $.ajax({
           type: 'PUT',
           url: '/api/board/update/' + brd_id,
           dataType: 'json',
           contentType: 'application/json; charset = utf-8',
           data: JSON.stringify(data)
        }).done(function () {
            alert('글이 수정되었습니다.');
            window.location.href = '/api/board/detail/' + brd_id;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }, delete: function () {
        var brd_id = $('#brd_id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/board/delete/' + brd_id,
            dataType: 'json',
            contentType: 'application/json; charset = utf-8'
        }).done(function () {
            alert('글이 삭제되었습니다.');
            window.location.href = '/board/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};

main.init();