$(function () {

});

//登出
$("#user-logout-btn").click(function () {
  $.ajax({
    url: "admin/logout",
    type: "POST",
    async: false,
    cache: false,
    success: function (result) {
      if (result && result.code === 200 && result.data) {
        window.location.href = result.data;
      } else {
        alert(result.msg);
      }
    },
    error: function () {
      alert("errOr fail");
    }
  });
});
