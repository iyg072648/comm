//댓글 길이 카운팅
function countingLength(content){
    if (content.value.length > 300){
        alert("댓글을 300자 이하로 입력해주세요.");
        content.value = content.value.substring(0, 300);
        content.focus();
    }
    document.getElementById("counter").innerText = content.value.length + `/300자`;
}

//댓글 저장
function saveComment(){
    const content = document.getElementById('content');
    isValid(content, '댓글');

    const boardId = [[ ${board.id}]],
    const params = {
        boardId: boardId,
        content: content.value,
        writer: '홍길동'
    }

    $.ajax({
        async: false,
        url: '/board/${boardId}/comments',
        type: 'post',
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify(params),
        success: function(response){
            console.log(response);
        },
        error: function(request, status, error){
            console.log(error)
        }
    })
}