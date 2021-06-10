var lectureId = $('#lectureId').val(); //강의 번호

$('[name=reviewInsertBtn]').click(function(){
    var insertData = $('[name=reviewInsertForm]').serialize(); //reviewInsert Form의 내용을 가져옴(직렬화)
    reviewInsert(insertData);
});


<!--수강평 목록-->
function reviewList(){
    $.ajax({
        url : '/review/list',
        type : 'get',
        data : {'lectureId':lectureId},
        dataType : 'json',
        success : function(data){
            console.log(data);
            var a ='';
            $.each(data, function(key, value){
                a += '<div class="reviewArea">';
                a +=    '<div class="reviewInfo'+value.id+'">'+'작성자 : '+value.email;
                /*a +=        '<a onclick="reviewUpdate('+value.id+',\''+value.content+'\');"> 수정 </a>';
                a +=        '<a onclick="reviewDelete('+value.id+');"> 삭제 </a>';*/
                a +=    '</div>';
                a +=    '<div class="reviewContent'+value.id+'">';
                a +=        '<textarea class="reviewText" disabled>'+value.content +'</textarea>';
                a +=        '<span class="reviewRegdate">'+value.regDate+'</span>';
                a +=    '</div>';
                a += '</div>';
            });

            $(".reviewList").html(a);
        }
    });
}
<!--수강평 등록-->
function reviewInsert(insertData){
    $.ajax({
        url : '/review/insert',
        type : 'post',
        data : insertData,
        success : function(data){
            console.log(insertData);
            if(data == 1) {
                reviewList(); //댓글 작성 후 댓글 목록 reload
                $('[name=content]').val('');
            }
        }
    });
}
/*수강평 수정 - 수강평 내용 출력을 input 폼으로 변경*/
function reviewUpdate(id, content){
    var a ='';

    a += '<div class="input-group">';
    a += '<input type="text" class="form-control" name="content_'+id+'" value="'+content+'"/>';
    a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="reviewUpdateProc('+id+');">수정</button> </span>';
    a += '</div>';

    $('.reviewContent'+id).html(a);

}

<!--수강평 수정-->
function reviewUpdateProc(id){
    var content = $('[name=content_'+id+']').val();

    $.ajax({
        url : '/review/update',
        type : 'post',
        data : {'content' : content, 'id' : id},
        success : function(data){
            if(data == 1) reviewList(); //댓글 수정후 목록 출력
        }
    });
}

<!--수강평 삭제-->
function reviewDelete(id){
    $.ajax({
        url : '/review/delete/',
        type : 'post',
        data : {'id' : id},
        success : function(data){
            if(data == 1) reviewList(id); //댓글 삭제후 목록 출력
        }
    });
}

$(document).ready(function(){
    reviewList(); //페이지 로딩시 댓글 목록 출력
});

<!-- ----수강평작성 모달창------   -->

const body = document.querySelector('body');
const modal = document.querySelector('.modal');
const btnOpenModal = document.querySelector('.btn-open-modal');
const btnCloseModal = document.querySelector('.btn-close-modal');
const btnWriteReview = document.querySelector('.btn-write-review');
const reviewContent = document.querySelector('.review-content');
const reviewText = document.querySelector('.reviewText');

btnOpenModal.addEventListener('click', () => {
    modal.classList.add('show');

    /*if (modal.classList.contains('show')) {
        body.style.overflow = 'hidden';
    }*/
});

btnCloseModal.addEventListener('click', (event) => {
    if (event.target === btnCloseModal) {
        modal.classList.toggle('show');
    }
});

modal.addEventListener('click', (event) => {
    if (event.target === modal) {
        modal.classList.toggle('show');

        /* if (!modal.classList.contains('show')) {
             body.style.overflow = 'auto';
         }*/
    }
});

btnWriteReview.addEventListener('click', () => {
    var insertData = $('[name=reviewInsertForm]').serialize();
    reviewInsert(insertData);
    modal.classList.toggle('show');
});