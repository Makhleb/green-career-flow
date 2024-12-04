/**
 * 이미지 타입 분석 함수
 * 이미지 출력시 src="return값" + base64String으로 사용
 * @param base64String
 * @returns {string}
 */
function loadImage(base64String) {
    // Base64 문자열 디코딩
    const binaryString = atob(base64String); // Base64 디코딩
    const header = [
        binaryString.charCodeAt(0),
        binaryString.charCodeAt(1),
        binaryString.charCodeAt(2),
        binaryString.charCodeAt(3),
    ].join(",");

    // 첫 4바이트를 추출하여 MIME 타입 분석
    switch (header) {
        case "255,216,255,224": // JPEG 파일 서명
        case "255,216,255,225": // JPEG EXIF 서명
            return "image/jpeg";
        case "137,80,78,71": // PNG 파일 서명
            return "image/png";
        case "71,73,70,56": // GIF 파일 서명
            return "image/gif";
        default:
            return "unknown";
    }
}

/**
 * 모달 조정 및 스크롤 고정 함수
 * 모달 사용시 가져가세요
 */
function modalToggle() {
    if ($('.modal').css('display') === "none") {
        $(".modal").show();
        document.body.style.overflow = 'hidden';
    } else {
        $(".modal").hide();
        document.body.style.overflow = 'auto';
    }
}

/**
 * 로그인 안하고 페이지 썼을 때 세션에 prevPage 넣기 위함
 */
function savePrevPageToSession(msg) {
    const prevPage = location.pathname; // 현재 페이지 URL
    axios.post('/api/session/savePrevPage', {prevPage: prevPage})
        .then(response => {
            console.log('요청 성공:', response.data);
            // msg 있을 때 alert 띄워줌
            if (!!msg) alert(msg);
            location.href = '/user/account/login';
        })
        .catch(error => {
            console.error('요청 실패:', error);
        });
}