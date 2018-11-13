/**
 * Created by walterwu on 2018/11/13.
 */

$(function () {
  var $loginEmail = $("#login-email");
  var $loginPassword = $("#login-password");
  var $chkSignUp = $("#checkbox-signup");

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
    $chkSignUp.prop("checked",true);
  }else {
    $chkSignUp.prop("checked",false);
  }

  //check状态触发
  $chkSignUp.click(function () {
    if ($(this).prop("checked")) {
      if (!$loginEmail.val() || !$loginPassword.val()){
        alert("信息不完整");
        $chkSignUp.prop("checked",false);
        return;
      }

      if (!isEmail($loginEmail.val())){
        alert("不是邮箱");
        $chkSignUp.prop("checked",false);
        return;
      }

      localStorage.setItem("localEmail",$loginEmail.val());
      localStorage.setItem("localPwd",$loginPassword.val());
    } else {
      localStorage.removeItem("localEmail");
      localStorage.removeItem("localPwd");
      alert("取消记住");
    }
  });

});
