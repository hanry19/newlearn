
//
//
// <td><input className="btn_wrap text-left"
//            type="submit" value="수정완료" th:formaction="@{/mypage/update}"></td>
// ;

const updateForm = document.querySelector(".memberUpdate"),
    updateBtn = updateForm.querySelector("button"),
    update = document.querySelector(".btn_wrap");

function init() {
    alert("버튼 눌림");
}
 update.addEventListener("click", init);


init();