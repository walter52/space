/**
 * Created by walterwu on 2018/04/08.
 */

/**
* 判断参数email是否是一个合法的电子邮箱
*
* @param email 电子邮箱
* @returns {boolean} 若参数email是一个合法的电子邮箱, 返回true; 否则返回false
*/
function isEmail(email) {
  var emailReg = /\w+[@]\w+[.]\w+/;
  if (email) {
    return emailReg.test(email);
  }
  return false;
}
