/**
 * 操作Cookie脚本
 *
 * @author deng.zhang
 * @since 1.0.0 2016-09-22 14:17
 */

/**
 * 添加cookie
 * hours为空字符串时, cookie的生存期至浏览器会话结束;
 * hours为数字0时, 建立的是一个无效的cookie, 这个cookie会覆盖已经建立过的同名、 同path的cookie（如果这个cookie存在）
 *
 * @param name cookie名字
 * @param value cookie值
 * @param hours 失效时间, 单位小时
 * @param path cookie路径
 */
function setCookie(name, value, hours, path) {
    name = encodeURI(name);
    value = decodeURI(value);
    var expireTime = new Date();
    expireTime.setTime(expireTime.getTime() + hours * 3600000);
    path = path == "" ? "" : ";path=" + path;
    var expires = (typeof hours) == "string" ? "" : ";expires=" + expireTime.toUTCString();
    document.cookie = name + "=" + value + expires + path;
}

/**
 * 获取cookie值
 *
 * @param name cookie名字
 * @returns {string} 若存在指定名字的cookie, 返回该cookie的值; 否则返回空串
 */
function getCookieValue(name) {
    name = encodeURI(name);
    // 读取文档的所有cookie
    var allCookies = document.cookie;
    // 查找名为name的cookie的开始位置
    name += "=";
    var cookiePosition = allCookies.indexOf(name);
    if (cookiePosition != -1) {
        var startPosition = cookiePosition + name.length; // cookie值开始的位置
        var endPosition = allCookies.indexOf(";", startPosition); // 从cookie值开始的位置起搜索第一个";"的位置, 即cookie值结尾的位置
        if (endPosition == -1) { // 如果endPosition的值为-1, 说明cookie列表里只有一个cookie
            endPosition = allCookies.length;
        }
        var value = allCookies.substring(startPosition, endPosition); // 提取cookie的值
        return decodeURI(value); // 解码
    } else {// 未找到cookie, 返回空字符串
        return "";
    }
}

/**
 * 删除cookie
 *
 * @param name cookie名字
 * @param path cookie路径
 */
function deleteCookie(name, path) {
    name = encodeURI(name);
    var expires = new Date(0);
    path = path == "" ? "" : ";path=" + path;
    document.cookie = name + "=" + ";expires=" + expires.toUTCString() + path;
}