var main = {
    init: function () {
        var _this = this;

        $('#btn-save').on('click', function () {
            if($('#title').val() == "") {
                alert('제목을 입력하세요!');
                return ;
            } else if($('#pw_bool').val() == false) {
                alert('비밀번호를 확인하세요!');
                return ;
            } else {
                $('textarea[name="content"]').html($('#summernote').summernote('code'));
                _this.save();
            }
        });

        $('#btn-update').on('click', function () {
            if($('#title').val() == "") {
                alert('제목을 입력하세요!');
                return ;
            } else if($('#pw_bool').val() == false) {
                alert('비밀번호를 확인하세요!');
                return ;
            } else {
                $('textarea[name="content"]').html($('#summernote').summernote('code'));
                _this.update();
            }
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    save: function () {
        var data = {
            brd_title: $('#title').val(),
            brd_content: $('textarea[name="content"]').val(),
            mem_nickname: $('#nickname').val(),
            mem_id: $('#session').val(),
            brd_cnt: 0,
            brd_category: $('#brd_ctg').val(),
        };

        $.ajax({
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            url: '/api/board/save/'
        }).done(function (brd_id) {
            alert('게시글이 저장되었습니다.');
            window.location.href = '/api/board/detail?brd_id=' + brd_id;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update: function () {
        var brd_id = $('#brd_id').val();
        var data = {
            brd_id: $('#brd_id').val(),
            brd_title: $('#title').val(),
            brd_content: $('textarea[name="content"]').val(),
            brd_category: $('#brd_ctg').val()
        };

        $.ajax({
            type: 'PUT',
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            data: JSON.stringify(data),
            url: '/api/board/update/' + brd_id
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
                alert('삭제되었습니다.. (｡•́︿•̀｡) ');
                window.location.href='/board/';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            })
        } else return false;
    }
};

main.init();