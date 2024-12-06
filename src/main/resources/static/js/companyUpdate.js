let base64img = null;
// todo 사진 확장자 탐지용 함수 loadImage 추가후 사용바람.
//현재 코드로는 png로 입출력시 깨짐현상 발생할 수 있음
//세션 체크 후 정보 입력
window.onload = function sessionCheck() {
    if (userSession == null) {
        alert("로그인된 세션이 없습니다. 메인으로 이동합니다.");
        location.href = "/";
    } else {
        base64img = userSession.companyImage;
        console.log(base64img);
        $('#companyId').val(userSession.companyId);
        $('#companyPw').val(userSession.companyPw);
        $('#companyName').val(userSession.companyName);
        $("#companyNumber").val(userSession.companyNumber);
        $("#companyZonecode").val(userSession.companyZonecode);
        $("#companyAddress").val(userSession.companyAddress);
        $("#companyAddressDetail").val(userSession.companyAddressDetail);
        $("#companyWebsite").val(userSession.companyWebsite);
        $('#companyBirth').val(userSession.companyBirth);
        $('#companyEmail').val(userSession.companyEmail);
        $('#companyContact').val(userSession.companyContact);
        $("#companyInfo").val(userSession.companyInfo);
        $('.preview').attr('src', loadImage(base64img));
        $('#companyEmployee').val(userSession.companyEmployee);
    }
}



/**
 * 비밀번호 일치확인 함수
 */
function pwEdit() {
    if ($('#modal-userPw').val() !== $('#modal-userPwCheck').val()) {
        alert("비밀번호 일치여부를 확인해주세요");
    } else {
        $('#companyPw').val($('#modal-userPwCheck').val());
        modalToggle();
    }
}

/**
 * 장소 팝업 오픈
 */
function addressFind() {
    new daum.Postcode({
        oncomplete: function (data) {
            console.log(data);
            $('#companyZonecode').val(data.zonecode);
            $('#companyAddress').val(data.address);
        }
    }).open();
}

/**
 * 세션 갱신
 */
function sessionUpdate() {
    axios.post("/api/company/account/session-edit")
        .then(function (response) {
            console.log(response);
        })
        .catch(function (error) {
            console.log(error);
        })
}

/**
 * 업데이트 함수
 */
function update() {
    if (confirm("정말루?")) {
        axios.put("/api/company/account/update", {
            companyId: $("#companyId").val(),
            companyPw: $("#companyPw").val(),
            companyName: $("#companyName").val(),
            companyNumber: $("#companyNumber").val(),
            companyZonecode: $("#companyZonecode").val(),
            companyAddress: $("#companyAddress").val(),
            companyAddressDetail: $("#companyAddressDetail").val(),
            companyWebsite: $("#companyWebsite").val(),
            companyEmail: $("#companyEmail").val(),
            companyContact: $("#companyContact").val(),
            companyBirth: $("#companyBirth").val(),
            companyInfo: $("#companyInfo").val(),
            companyImage: base64img,
            companyEmployee: $('#companyEmployee').val()
        })
            .then(function (response) {
                if (response.data) {
                    sessionUpdate()
                    alert("회원정보 수정 성공")
                    location.reload(true);
                } else {
                    alert("오류 발생(수정되지 않음)");
                }
            })
            .catch(function (error) {
                console.log(error);
            })
    }
}

/**
 * 회원 탈퇴 코드
 */
function deleteCompany() {
    if (confirm("정말 삭제하시겠습니까? ")) {
        axios.delete('/api/company/account/delete/' + userSession.companyId)
            .then(function (response) {
                if (response.data) {
                    alert("삭제가 완료되었습니다. 감사합니다.");
                    location.href = "/";
                }
            })
            .catch(function (error) {
                console.log(error);
            })
    }
}

/**
 * 이미지 삽입 및 프리뷰 함수
 * @param event
 */
function imgPreview(event) {
    const file = event.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function (e) {
            $('.preview').attr('src', e.target.result).show();
            $('label[for="companyAttachment"]').hide();
            $('#close-btn').show();
            base64img = e.target.result;
            console.log(base64img);
        }
        reader.readAsDataURL(file); // 파일을 Base64로 읽음
    }
}

/**
 * 이미지 삭제 함수
 */
function imgDelete() {
    $('.preview').attr('src', '').hide();
    $('#companyAttachment').val('');
    $('label[for="companyAttachment"]').show();
    $('#close-btn').hide();
    $('#plus-btn').show();
    base64img = null;
}