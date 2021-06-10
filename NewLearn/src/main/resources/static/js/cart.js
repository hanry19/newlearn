
let sum = 0;
let discount = 0;

function itemSum() {
    sum = 0;
    var str = "";
    /*      var count = $(".lecture_price").length;
            var price = $(".lecture_price");
            sum += parseInt(price[i].value);
            $("#total_sum").html(sum+" 원");   */
    $('.lecture_price').each(function (index, item) {
        const price = parseInt($(item).text());
        sum += price;
    });
    sum -= discount;
    $("#total_sum").html(sum);
}

itemSum();

$('.delete-btn').click(function () {
    var confirm_val = confirm("정말 삭제하시겠습니까?");

    if (confirm_val) {
        var cartId = $(this).attr('value');

        $.ajax({
            url: "/cart/delete",
            type: "post",
            data: {cartId: cartId},
            success: function (result) {
                if (result == 1) {
                    location.href = "/cart/list";
                } else {
                    alert("삭제 실패");
                }
            }

        })
    }
});

function coupon() {
    var couponCode = $('#couponCode').val();
    if (couponCode == "") {
        alert('쿠폰코드를 입력하세요');
        couponCode.focus();
        return false;
    }
    $.ajax({
        url: "/cart/coupon-count",
        type: "get",
        data: {couponCode: couponCode},
        success: function (result) {
            if (result == 0) {
                alert("※ 맞는 쿠폰이 없습니다 ※");
            } else {
                $.ajax({
                    url: "/cart/coupon",
                    type: "get",
                    data: {couponCode: couponCode},
                    success: function (result) {
                        discount = result;
                        itemSum();
                        alert(couponCode + '쿠폰이 적용되었습니다!');
                    }
                });
            }
        }
    });
}

function payment() {

    var name = $('#name').val();
    var tel = $('#tel').val();
    var email = $('#email').val();
    var orderForm = $('.orderForm')

    if (name == "") {
        alert('이름을 입력하세요');
        name.focus();
        return false;
    }
    if (tel == "") {
        alert('전화번호를 입력하세요');
        tel.focus();
        return false;
    }
    if (email == "") {
        alert('이메일을 입력하세요');
        email.focus();
        return false;
    }

    var IMP = window.IMP; // 생략가능
    IMP.init('imp37422895');
    IMP.request_pay({
        pg: 'html5_inicis',
        pay_method: 'card',
        merchant_uid: 'merchant_' + new Date().getTime(),
        name: '뉴런 강의', //결제창에서 보여질 이름
        amount: sum, //실제 결제되는 가격
        buyer_email: email,
        buyer_name: name,
        buyer_tel: tel,
    }, function (rsp) {
        if (rsp.success) {
            var msg = '결제가 완료되었습니다.';
            msg += '고유ID : ' + rsp.imp_uid;
            msg += '상점 거래ID : ' + rsp.merchant_uid;
            msg += '결제 금액 : ' + rsp.paid_amount;
            msg += '카드 승인번호 : ' + rsp.apply_num;
        } else {
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
        }
        alert(msg);
        orderForm.submit();
    });
}