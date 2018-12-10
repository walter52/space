/**
 * Created by walterwu on 2018/11/13.
 */
var $loginForm = $("#login-form");
var $loginEmail = $loginForm.find("input[name=loginEmail]");
var $loginPassword = $loginForm.find("input[name=loginPwd]");
var $chkSignUp = $loginForm.find("input[name=isRemember]");
var isRemember = false;

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
    isRemember = true;
  } else {
    $chkSignUp.prop("checked", false);
    isRemember = false;
  }

  //初始化弹出窗
  $loginEmail.popover({
    content: "<div class='red' id='popover-content-email'></div>",
    html: true,
    trigger:"manual",
    animation: true
  });
  $loginPassword.popover({
    content: "<div class='red' id='popover-content-pwd'></div>",
    html: true,
    trigger:"manual",
    animation: true
  });


});

//check状态触发
$chkSignUp.click(function () {
  if ($(this).prop("checked")) {
    // if (!$loginEmail.val() || !$loginPassword.val()) {
    //   alert("信息不完整");
    //   $chkSignUp.prop("checked", false);
    //   return;
    // }
    //
    // if (!isEmail($loginEmail.val())) {
    //   alert("不是邮箱");
    //   $chkSignUp.prop("checked", false);
    //   return;
    // }
    if (!checkLoginEmail()){
      $chkSignUp.prop("checked", false);
    }
  } else {
    localStorage.removeItem("localEmail");
    localStorage.removeItem("localPwd");
    $loginEmail.val("");
    $loginPassword.val("");
    isRemember = false;
    alert("取消记住");
  }
});

//登录
$("#user-login-btn").click(function () {
  $.ajax({
    url: "admin/login",
    type: "POST",
    data: {
      loginEmail: $loginEmail.val(),
      loginPwd: $loginPassword.val(),
      isRemember: isRemember
    },
    async: false,
    cache: false,
    success: function (result) {
      if (result.code === 200) {
        if ($chkSignUp.prop("checked")) {
          localStorage.setItem("localEmail", result.data.email);
          localStorage.setItem("localPwd", result.data.password);
        }
        window.location.href = window.location.href.replace("login.html", "");
      } else {
        alert(result.msg);
      }
    },
    error: function () {
      alert("errOr fail");
    }
  });
});

function checkLoginEmail() {
  var res = false;
  if (!$loginEmail.val()) {
    $loginEmail.parent().addClass("has-error");
    $loginEmail.focus();
    $loginEmail.popover("show");
    $("#popover-content-email").text("Email不能为空");
  }else if (!isEmail($loginEmail.val())){
    $loginEmail.parent().addClass("has-error");
    $loginEmail.focus();
    $loginEmail.popover("show");
    $("#popover-content-email").text("Email格式错误");
  }else {
    $loginEmail.popover("hide");
    $loginEmail.parent().removeClass("has-error");
    res = true
  }
  return res;
}

