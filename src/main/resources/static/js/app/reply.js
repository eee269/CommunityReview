var main = {
    init: function () {
        var _this = this;
        $('#btn_rep_save').on('click', function () {
            _this.save();
        });


    },
    save: function () {
        var data = {
            rep_content: $('#rep_content').val(),
            mem_id: $('#mem_id').val(),
            mem_nickname: $('#nickname').val(),
            // rep_parent: 직전 li의 rep_id 받아와야지,
            // rep_depth: rep_parent`s depth +1
            // rep_seq: service에서 repository 한번 더 호출
            // UPDATE Reply r SET r.rep_seq = r.rep_seq + 1 WHERE r.rep_id=?1 AND r.rep_seq>?2
            // 1: rep_id, 2: rep_seq
        };
        $.ajax({
            url: '/api/reply/save',
            data: JSON.stringify(data),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            type: 'POST'
        }).done(function () {
            alert('등록되었습니다!');
            window.location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update: function() {
        var data = {

        };
        $.ajax({
            url: '/api/reply/update/' + rep_id,
            data: JSON.stringify(data),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            type: 'PUT'
        }).done(function () {
            alert('수정되었습니다!');
            window.location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete: function () {
        if(confirm("정말 삭제하시겠습니까?")) {
            $.ajax({
                url: '/api/reply/delete/' + rep_id,
                type: 'DELETE'
            }).done(function () {
                alert('삭제되었습니다!');
                window.location.reload();
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        } else return false;
    }
};

main.init();