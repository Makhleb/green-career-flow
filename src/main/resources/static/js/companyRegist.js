let duplicateCompany = true;
let base64img = null;

// todo 기업 회원가입 유효성 검사 필요
/**
 * 회사 id 중복확인
 * @returns {boolean}
 */
function duplicateCompanyCheck() {
    if (!/^[a-zA-Z0-9]{4,20}$/.test($('#companyId').val())) {
        alert("ID는 영문/숫자로 4자 ~ 20자 이내로만 작성가능합니다.")
        return true;
    }

    let companyId = $('#companyId').val();
    axios.get('/api/company/account/check-id/' + companyId)
        .then(function (response) {
            if (response.data !== 0) {
                alert("중복된 id 입니다");
                duplicateCompany = true;
            } else {
                alert("사용가능한 id 입니다");
                duplicateCompany = false;
            }
        })
        .catch(function (error) {
            console.log(error);
        })
}

/**
 * 이미지 삭제 함수
 */
function imgDelete(){
    $('.preview').attr('src','#').hide();
    $('#companyAttachment').val('');
    $('label[for="companyAttachment"]').show();
    $('.close').hide();
    base64img = null;
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
            $('.preview').attr('src',e.target.result).show();
            $('label[for="companyAttachment"]').hide();
            $('.close').show();
            base64img = e.target.result;
            console.log(base64img);
        }
        reader.readAsDataURL(file); // 파일을 Base64로 읽음
    }
}

/**
 * 주소 찾기
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
 * 기업등록api 함수
 */
function companyRegist() {

    axios.post("/api/company/account/regist", {
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
        companyImage: base64img.split(',')[1],
        companyEmployee: $('#companyEmployee').val()
    })
        .then(function (response) {
            if (response.data) {
                alert("회원등록 성공 로그인으로 이동합니다.")
                location.href = "/user/account/login";
            } else {
                alert("로그인 오류 발생");
            }
        })
        .catch(function (error) {
            console.log(error);
        })
}