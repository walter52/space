/**
 * Created by walterwu on 2018/11/13.
 */
var $loginForm = $("#loginform");
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
    trigger: "manual",
    animation: true
  });
  $loginPassword.popover({
    content: "<div class='red' id='popover-content-pwd'></div>",
    html: true,
    trigger: "manual",
    animation: true
  });

});

//check状态触发
$chkSignUp.click(function () {
  if ($(this).prop("checked")) {
    if (!checkLoginEmail()) {
      $chkSignUp.prop("checked", false);
      return;
    }
    if (!checkLoginPwd()) {
      $chkSignUp.prop("checked", false);
      return;
    }
  } else {
    localStorage.removeItem("localEmail");
    localStorage.removeItem("localPwd");
    $loginEmail.val("");
    $loginPassword.val("");
    isRemember = false;
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

//监听表单
$("[data-toggle='popover']").click(function () {
  $loginEmail.popover("hide");
  $loginPassword.popover("hide");
});

//监听回车
$("body").keydown(function (e) {
  if(e.keyCode == 13){
    $("#user-login-btn").trigger("click");
  }
});

function checkLoginEmail() {
  var res = false;
  if (!$loginEmail.val()) {
    $loginEmail.focus();
    $loginEmail.popover("show");
    $("#popover-content-email").text("Email不能为空！");
  } else if (!isEmail($loginEmail.val())) {
    $loginEmail.focus();
    $loginEmail.popover("show");
    $("#popover-content-email").text("Email格式错误！");
  } else {
    $loginEmail.popover("hide");
    res = true
  }
  return res;
}

function checkLoginPwd() {
  var res = false;
  if (!$loginPassword.val()) {
    $loginPassword.focus();
    $loginPassword.popover("show");
    $("#popover-content-pwd").text("密码不能为空！");
  }else {
    $loginPassword.popover("hide");
    res = true;
  }
  return res
}

