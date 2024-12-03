window.onload = function sessionCheck() {
    if (userSession == null) {
        alert("로그인된 세션이 없습니다. 메인으로 이동합니다.");
        location.href = "/";
    } else {
        $('#userId').val(userSession.userId);
        $('#userPw').val(userSession.userPw);
        $('#userName').val(userSession.userName);
        $('#userBirth').val(userSession.userBirth);
        $('#userEmail').val(userSession.userEmail);
        $('#userPhone').val(userSession.userPhone);

        if (userSession.userGender === "M") {
            $('#gender-male').prop('checked', true);
        } else if (userSession.userGender === "F") {
            $('#gender-female').prop('checked', true);
        }
    }
}

function pwEdit() {
    if($('#modal-userPw').val() !== $('#modal-userPwCheck').val()) {
        alert("비밀번호 일치여부를 확인해주세요");
    } else{
        $('#userPw').val($('#modal-userPwCheck').val());
        modalToggle();
    }
}

function update() {
    axios.put("/api/user/account/update", {
        userId: $("#userId").val(),
        userPw: $("#userPw").val(),
        userName: $("#userName").val(),
        userPhone: $("#userPhone").val(),
        userEmail: $("#userEmail").val(),
        userGender: $("input[name='optionGender']:checked").val(),
        userBirth: $("#userBirth").val()
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

function sessionUpdate(){
    axios.post("/api/user/account/session-edit")
        .then(function (response) {
            console.log(response);
        })
        .catch(function (error) {
            console.log(error);
        })
}

function deleteUser() {
    if (confirm("정말 삭제하시겠습니까? ")) {
        console.log(userSession);
        axios.delete('/api/user/account/delete/' + userSession.userId)
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