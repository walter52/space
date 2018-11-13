/**
 * Created by walterwu on 2018/11/13.
 */
var $loginForm = $("#login-form");
var $loginEmail = $loginForm.find("input[name=loginEmail]");
var $loginPassword = $loginForm.find("input[name=loginPwd]");
var $chkSignUp = $loginForm.find("input[name=chkSignIn]");

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

    localStorage.setItem("localEmail", $loginEmail.val());
    localStorage.setItem("localPwd", $loginPassword.val());
  } else {
    localStorage.removeItem("localEmail");
    localStorage.removeItem("localPwd");
    alert("取消记住");
  }
});

$("#userLoginBtn").click(function () {
  var loginFromData = new FormData($loginForm[0]);
  $.ajax({
    url: "admin/login",
    type: "POST",
    data: loginFromData,
    async: false,
    cache: false,
    processData : false,  //如果要发送 DOM 树信息或其它不希望转换的信息，请设置为 false
    success: function (result) {
      if (result.status == 0) {
        alert("success");
      } else {
        alert("fail");
      }
    },
    error: function () {
      alert("fail");
    }
  });
});

