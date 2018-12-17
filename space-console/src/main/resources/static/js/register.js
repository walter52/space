/**
 * Created by walterwu on 2018/12/17.
 */

var $registerForm = $("#registerform");
var $registerName = $registerForm.find("input[name=register-name]");
var $registerEmail = $registerForm.find("input[name=register-email]");
var $registerPwd = $registerForm.find("input[name=register-pwd]");

$(function () {

  //初始化弹出窗
  $registerName.popover({
    content: "<div class='red' id='popover-content-name'></div>",
    html: true,
    trigger: "manual",
    animation: true
  });
  $registerEmail.popover({
    content: "<div class='red' id='popover-content-email'></div>",
    html: true,
    trigger: "manual",
    animation: true
  });
  $registerPwd.popover({
    content: "<div class='red' id='popover-content-pwd'></div>",
    html: true,
    trigger: "manual",
    animation: true
  });
});

//注册
$("#user-register-btn").click(function () {
  if(!checkRegisterName()||!checkRegisterEmail()||!checkRegisterPwd()){
    return;
  }
  $.ajax({
    url:"admin/register",
    type:"POST",
    data:{
      registerName:$registerName.val(),
      registerEmail:$registerEmail.val(),
      registerPwd:$registerPwd.val()
    },
    async: false,
    cache: false,
    success:function (result) {

    },
    error:function () {
      alert("errOr fail");
    }
  });
});

//监听回车
$("body").keydown(function (e) {
  if(e.keyCode == 13){
    $("#user-register-btn").trigger("click");
  }
});

function checkRegisterName() {
  var res = false;
  if (!$registerName.val()) {
    $registerName.focus();
    $registerName.popover("show");
    $("#popover-content-name").text("Name不能为空！");
  } else if ($registerName.val().length >= 10) {
    $registerName.focus();
    $registerName.popover("show");
    $("#popover-content-name").text("Name长度不能超过10！");
  } else {
    $registerName.popover("hide");
    res = true
  }
  return res;
}

function checkRegisterEmail() {
  var res = false;
  if (!$registerEmail.val()) {
    $registerEmail.focus();
    $registerEmail.popover("show");
    $("#popover-content-email").text("Email不能为空！");
  } else if (!isEmail($registerEmail.val())) {
    $registerEmail.focus();
    $registerEmail.popover("show");
    $("#popover-content-email").text("Email格式错误！");
  } else {
    $registerEmail.popover("hide");
    res = true
  }
  return res;
}

function checkRegisterPwd() {
  var res = false;
  var $confirmPwd = $registerForm.find("input[name=register-confirm-pwd]");
  if (!$registerPwd.val()) {
    $registerPwd.focus();
    $registerPwd.popover("show");
    $("#popover-content-pwd").text("密码不能为空！");
  }  else if (!($registerPwd.val() === $confirmPwd.val())) {
    $registerPwd.focus();
    $registerPwd.popover("show");
    $("#popover-content-pwd").text("两次密码输入的不一致！");
  } else {
    $registerPwd.popover("hide");
  }
  return res;
}

$("[data-toggle='popover']").click(function () {
  $registerName.popover("hide");
  $registerEmail.popover("hide");
  $registerPwd.popover("hide");
});
