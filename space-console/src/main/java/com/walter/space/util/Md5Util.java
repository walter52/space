package com.walter.space.util;

import com.walter.space.util.codec.HexCodec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * MD5工具类
 *
 * @since 1.0.0
 * Created on 2016-10-24 19:53
 */
public class Md5Util {
    /**
     * logger
     */
    private static final Logger LOGGER = Logger.getLogger(Md5Util.class.getName());
    /**
     * 消息摘要
     */
    private static MessageDigest messageDigest = null;

    static {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            LOGGER.log(Level.FINEST, "Md5Util MessageDigest初始化失败", e);
        }
    }

    /**
     * 获取文本摘要信息
     *
     * @param plainText 文本
     * @return 摘要信息, 若参数plainText为null, 则返回null
     * @throws Exception
     */
    public static String md5(String plainText) throws Exception {
        if (plainText == null) {
            return null;
        }
        return md5(plainText.getBytes());
    }

    /**
     * 获取摘要信息
     *
     * @param bytes 字节数组
     * @return 文件摘要信息, 十六进制编码, 小写字符
     * @throws Exception
     */
    public static String md5(byte[] bytes) throws Exception {
        messageDigest.update(bytes);
        return HexCodec.encodeHexString(messageDigest.digest(), true);
    }
}
