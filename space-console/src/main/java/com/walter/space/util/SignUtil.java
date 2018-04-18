package com.walter.space.util;

import com.tcl.mibc.platform.api.exception.SignFailException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SignUtil {

  private static final Logger logger = LoggerFactory.getLogger(SignUtil.class);

  private static String KEY = "#87&$#1@90";

  public static void checkSign(List<String> signName, String sign) throws SignFailException {
    String serverSign = "";
    for (String name : signName) {
      if (StringUtils.isNotBlank(name)) {
        serverSign = serverSign + name + "&";
      }
    }
    serverSign = serverSign + KEY;
    serverSign = MD5Util.MD5Encode(serverSign, "UTF-8");
    if (!serverSign.equals(sign)) {
      logger.error("签名参数列表" + signName);
      throw new SignFailException("签名验证失败！！" + "[serverSign=" + serverSign + "]" + "[clientSign=" + sign
          + "]");
    }
  }

}
