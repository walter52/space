package com.walter.space.util;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class EncryptUtils {

    private final static String[] HEX_DIGITS = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static Object SALT = "walter-wu-space-salt";

    /**
     * 获取字符串的md5/sha1
     *
     * @param rawPass 要加密的字符串
     */
    public static String encrypt(String rawPass, EncryptType encryptType) {
        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance(encryptType.getType());
            // 加密后的字符串
            result = byteArrayToHexString(md.digest(mergePasswordAndSalt(
                    rawPass).getBytes(StandardCharsets.UTF_8)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * 获取文件的md5/sha1
     *
     * @return 文件的md5或者sha
     */
    public static String encryptFile(File file, EncryptType encryptType) {
        String result = null;
        FileInputStream fis;
        try {
            MessageDigest md = MessageDigest.getInstance(encryptType.getType());
            fis = new FileInputStream(file);
            byte[] buffer = new byte[8192];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            result = byteArrayToHexString(md.digest());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    private static String mergePasswordAndSalt(String password) {
        if (password == null) {
            password = "";
        }

        if ((SALT == null) || "".equals(SALT)) {
            return password;
        } else {
            return password + "{" + SALT.toString() + "}";
        }
    }

    /**
     * 转换字节数组为16进制字串
     *
     * @param b 字节数组
     * @return 16进制字串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }

    /**
     * 加密枚举类型
     */
    public enum EncryptType {
        /**
         * md5加密
         */
        MD5("MD5"),
        /**
         * sha加密
         */
        SHA("SHA");
        private String type;

        EncryptType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }


}
