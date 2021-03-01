$(function () {
    $('#summernote').summernote({
        height: 500,                 // 에디터 높이
        minHeight: null,             // 최소 높이
        maxHeight: null,             // 최대 높이
        focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
        lang: "ko-KR",					// 한글 설정
        placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정
        tabSize: 2,
        prettifyHtml: false,
        toolbar: [
            ['style', ['style']],
            ['fontname', ['fontname']],
            ['fontsize', ['fontsize']],
            ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['table', ['table']],
            ['insert', ['link', 'picture', 'video']],
            ['view', ['fullscreen', 'codeview', 'help']]
        ],
        fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
        fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],

        // callbacks: {	//여기 부분이 이미지를 첨부하는 부분
        //     onImageUpload : function(files) {
        //         uploadSummernoteImageFile(files[0],this);
        //     },
        //     onPaste: function (e) {
        //         var clipboardData = e.originalEvent.clipboardData;
        //         if (clipboardData && clipboardData.items && clipboardData.items.length) {
        //             var item = clipboardData.items[0];
        //             if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
        //                 e.preventDefault();
        //             }
        //         }
        //     }
        // }
        callbacks: {
            onImageUpload: function(files, editor, welEditable) {
                for(var i = files.length -1; i>=0; i--) {
                    sendFile(files[i], this);
                }
            }
        }

    });

    // function uploadSummernoteImageFile(file, editor) {
    //     data = new FormData();
    //     data.append("file", file);
    //     $.ajax({
    //         data : data,
    //         type : "POST",
    //         url : "/uploadSummernoteImageFile",
    //         contentType : false,
    //         processData : false,
    //         success : function(data) {
    //             //항상 업로드된 파일의 url이 있어야 한다.
    //             $(editor).summernote('insertImage', data.url);
    //         }
    //     });
    // }
})