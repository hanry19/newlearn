var lecturePrice = parseInt($('#lecture-price').text()); //강의 가격
var lectureId = $('#lectureId').val(); //강의 번호

$('#subscription').click(function () {
    $.ajax({
        url: '/cart/lecture-exist',
        type: 'get',
        data: {lectureId: lectureId},
        success: function (result) {
            if (result == 0) {
                $.ajax({
                    url: '/cart/insert',
                    type: 'post',
                    data: {lectureId: lectureId},
                    success: function (result) {
                        alert('강의가 장바구니에 담겼습니다!!')
                        console.log(result);
                    },
                    error: function (xhr) {
                        alert("cart insert fail");
                    }
                });
            }else {
                alert('이미 장바구니에 있는 강의입니다.');
            }
        },
        error: function (xhr) {
            alert("cart lecture-exist fail");
        }
    });
})