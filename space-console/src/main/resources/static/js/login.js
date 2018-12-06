/**
 * Created by walterwu on 2018/11/13.
 */
var $loginForm = $("#login-form");
var $loginEmail = $loginForm.find("input[name=loginEmail]");
var $loginPassword = $loginForm.find("input[name=loginPwd]");
var $chkSignUp = $loginForm.find("input[name=isRemember]");

//初始化数据
$(function () {
  //查看本地存储信息的处理
  var localEmail = localStorage.getItem("localEmail");
  var localPwd = localStorage.getItem("localPwd");
  if (localEmail) {
    $loginEmail.val(localEmail);
  }
  if (localPwd) {
    $loginPassword.val(localPwd);
  }
  if (localEmail && localPwd) {
    $chkSignUp.prop("checked", true);
  } else {
    $chkSignUp.prop("checked", false);
  }
});

//check状态触发
$chkSignUp.click(function () {
  if ($(this).prop("checked")) {
    if (!$loginEmail.val() || !$loginPassword.val()) {
      alert("信息不完整");
      $chkSignUp.prop("checked", false);
      return;
    }

    if (!isEmail($loginEmail.val())) {
      alert("不是邮箱");
      $chkSignUp.prop("checked", false);
      return;
    }

  } else {
    localStorage.removeItem("localEmail");
    localStorage.removeItem("localPwd");
    alert("取消记住");
  }
});

$("#userLoginBtn").click(function () {
  $.ajax({
    url: "admin/login",
    type: "POST",
    data: {
      loginEmail:$loginEmail.val(),
      loginPwd:$loginPassword.val(),
      isRemember:$chkSignUp.prop("checked")
    },
    async: false,
    cache: false,
    success: function (result) {
      if (result.code == 200) {
        if($chkSignUp.prop("checked")){
          localStorage.setItem("localEmail", result.data.email);
          localStorage.setItem("localPwd", result.data.password);
        }
        window.location.href.replace("login.html", "");
        window.location.href = "http://127.0.0.1:8080/console/"
      } else {
        alert("fail");
      }
    },
    error: function () {
      alert("errOr fail");
    }
  });
});

