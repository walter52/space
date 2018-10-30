$(function () {
  var $userEmail = $("#user-email");
  var $userPassWd = $("#user-passwd");
  var cookie = $.AMUI.utils.cookie;

  //查看是否保存cookies
  var userEmailCookie = cookie.get("waem");
  if(userEmailCookie){
    $userEmail.val(userEmailCookie.replace(/\s+/g,""));
  }
  var userPassWdCookie = cookie.get("wapd");
  if(userPassWdCookie){
    $userPassWd.val(userPassWdCookie.replace(/\s+/g,""));
  }

  $("#login-submit").click(function () {
    if (!$userEmail.val()||!isEmail($userEmail.val())) {
        $userEmail.focus();
      alert('不想说!');
      $userEmail.popover({
        content: 'Popover via JavaScript'
      })
    }
  });
});

function isEmail(email) {
  var emailReg = /\w+[@]\w+[.]\w+/;
  if (email) {
    return emailReg.test(email);
  }
  return false;
}
