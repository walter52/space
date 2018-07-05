/**
 * 登录的js文件
 * Created by walterwu on 2018/04/04.
 */

$(function () {

  var $loginForm = $("#login-form");
  var $email = $loginForm.find("input[name=email]");
  var $password = $loginForm.find("input[name=password]");
  var $remember = $loginForm.find("input[name=rememberMeCheckbox]");
  var $longinBtn = $loginForm.find("button[name=loginBtn]");
  var $forgetPassword = $loginForm.find("a[name=forgetPasswordBtn]");

  //从cookie中填充
  var emailCookie = getCookieValue("waem");
  if (emailCookie) {
    $email.val(emailCookie);
  }

  var passwordCookie = getCookieValue("wapd");
  if (passwordCookie) {
    $password.val(passwordCookie);
  }

  var useCookie = false;
  if (emailCookie && passwordCookie) {
    useCookie = true;
  }

  document.onkeydown = function (e) {
    //回车自动点击登录按钮
    if (e.keyCode == 13) {
      $longinBtn.click();
    }
  };
  //配置checkbox
  $remember.iCheck({
    checkboxClass: 'icheckbox_square-blue',
    radioClass: 'iradio_square-blue',
    increaseArea: '20%' /* optional */
  });

  //记住登录状态
  $remember.on("ifUnchecked", function () {
    deleteCookie("wapd", "/")
  });

  //忘记密码
  $forgetPassword.click(function () {
    bootbox.alert("请联系管理员！");
  });

  //执行登录操作
  $longinBtn.click(function () {
    //email内容判断
    if (!$email.val() || !isEmail($email.val())) {
      $email.parent().addClass("has-error");
      $email.focus();
      $email.popover({
        content: "<div class='red'>无效email！</div>",
        html: true,
        animation: true
      }).popover("show");
      return;
    } else {
      $email.popover("hide");
      $email.parent().removeClass("has-error");
    }
    //password判断
    if (!$password.val()) {
      $email.parent().addClass("has-error");
      $email.focus();
      $email.popover({
        content: "<div class='red'>请输入密码！</div>",
        html: true,
        animation: true
      }).popover("show");
      return;
    } else {
      $email.popover("hide");
      $email.parent().removeClass("has-error");
    }

    $.ajax({
      "url": "admin/login",
      "type": "POST",
      "data": {
        "email": $email.val(),
        "password": $password.val(),
        "remember": $remember.prop("checked"),
        "useCookie": useCookie
      },
      "success": function (result) {
        if(result.code == 0){
          window.location.href = window.location.href.replace("login.html", "");
        }else{
          bootbox.alert(result.msg);
        }

      },
      "error": function (result) {
        bootbox.alert("网络错误！");
      }
    })
  });

});
