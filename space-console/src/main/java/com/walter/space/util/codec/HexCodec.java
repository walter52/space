package com.walter.space.util.codec;

import java.nio.charset.Charset;

/**
 * Converts hexadecimal Strings.
 *
 * @since 1.0.0
 * Created Time: 2016-10-24 19:53
 */
public class HexCodec {
    /**
     * Used to build output as Hex
     */
    private static final char[] DIGITS_LOWER =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * Used to build output as Hex
     */
    private static final char[] DIGITS_UPPER =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * Converts an array of bytes into a string representing the hexadecimal values of each byte in order.
     * The returned string will be double the length of the passed array, as it takes two characters to
     * represent any given byte.
     * The hexadecimal characters of returned string are uppercase.
     *
     * @param data a byte[] to convert to Hex characters
     * @return a string containing hexadecimal characters
     * @throws EncoderException
     */
    public static String encodeHexString(final byte[] data) throws EncoderException {
        return encodeHexString(data, false);
    }

    /**
     * Converts an array of bytes into a string representing the hexadecimal values of each  byte in order.
     * The returned string will be double the length of the passed array, as it takes two characters to represent any
     * given byte.
     *
     * @param data a byte[] to convert to Hex string
     * @param toLowerCase true converts to lowercase,false to uppercase
     * @return a string containing hexadecimal characters
     * @throws EncoderException
     */
    public static String encodeHexString(final byte[] data,final boolean toLowerCase) throws EncoderException {
        char[] chars = encodeHex(data,toLowerCase);
        return new String(chars);
    }

    /**
     * Converts an array of bytes into an array of characters representing the hexadecimal values of each byte in order.
     * The returned array will be double the length of the passed array, as it takes two characters to represent any
     * given byte.
     *
     * @param data
     *            a byte[] to convert to Hex characters
     * @param toLowerCase
     *            true converts to lowercase,false to uppercase
     * @return A char[] containing hexadecimal characters
     */
    public static char[] encodeHex(final byte[] data, final boolean toLowerCase) throws EncoderException {
        return encodeHex(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
    }

    /**
     * Converts an array of bytes into an array of characters representing the hexadecimal values of each byte in order.
     * The returned array will be double the length of the passed array, as it takes two characters to represent any
     * given byte.
     *
     * @param data
     *            a byte[] to convert to Hex characters
     * @param toDigits
     *            the output alphabet
     * @return A char[] containing hexadecimal characters
     */
    protected static char[] encodeHex(final byte[] data, final char[] toDigits) {
        final int l = data.length;
        final char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
            out[j++] = toDigits[0x0F & data[i]];
        }
        return out;
    }

    /**
     * Converts a string representing hexadecimal values into a string.
     * The returned string will be half the length of the passed string, as it takes two characters to represent any
     * given byte.
     *
     * @param data a string containing hexadecimal digits
     * @return a string
     * @throws DecoderException thrown if
     */
    public static String decodeToString(final String data) throws DecoderException {
        return decodeToString(data,Charset.defaultCharset());
    }

    /**
     * Converts a string representing hexadecimal values into a string.
     * The returned string will be half the length of the passed string, as it takes two characters to represent any
     * given byte.
     *
     * @param data a string containing hexadecimal digits
     * @param charsetName the name of charset,used to convert byte array to string
     * @return a string
     * @throws DecoderException
     */
    public static String decodeToString(final String data,String charsetName) throws DecoderException {
        return decodeToString(data,Charset.forName(charsetName));
    }

    /**
     * Converts a string representing hexadecimal values into a string.
     * The returned string will be half the length of the passed string, as it takes two characters to represent any
     * given byte.
     *
     * @param data a string containing hexadecimal digits
     * @param charset used to convert byte array to string
     * @return a string
     * @throws DecoderException
     */
    public static String decodeToString(final String data,Charset charset) throws DecoderException {
        byte[] out = decodeHexString(data);
        return new String(out,charset);
    }

    /**
     * Converts a string representing hexadecimal values into an array of bytes.
     * The returned array will be half the length of the passed string, as it takes two characters to represent any
     * given byte. An exception is thrown if the passed string is null or empty or has an odd number of elements.
     *
     * @param data a string containing hexadecimal digits
     * @return a byte array containing binary data decoded from the passed string.
     * @throws DecoderException if passed string is null or empty or has odd number of elements will be thrown.
     */
    public static byte[] decodeHexString(final String data) throws DecoderException {
        if (null == data || "".equals(data.trim())) {
            throw new DecoderException("Argument is a null or empty");
        }
        final int length = data.length();

        if ((length & 0x01) != 0) {
            throw new DecoderException("Odd length of string");
        }

        return decodeHexCharArray(data.toCharArray());
    }

    /**
     * Converts an array of characters representing hexadecimal values into an array of bytes of those same values. The
     * returned array will be half the length of the passed array, as it takes two characters to represent any given
     * byte. An exception is thrown if the passed char array has an odd number of elements.
     *
     * @param data
     *            An array of characters containing hexadecimal digits
     * @return A byte array containing binary data decoded from the supplied char array.
     * @throws DecoderException
     *             Thrown if an odd number or illegal of characters is supplied
     */
    public static byte[] decodeHexCharArray(final char[] data) throws DecoderException {

        final int len = data.length;

        if ((len & 0x01) != 0) {
            throw new DecoderException("Odd number of characters.");
        }

        final byte[] out = new byte[len >> 1];

        // two characters form the hex value.
        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(data[j], j) << 4;
            j++;
            f = f | toDigit(data[j], j);
            j++;
            out[i] = (byte) (f & 0xFF);
        }

        return out;
    }

    /**
     * Converts a hexadecimal character to an integer.
     *
     * @param ch
     *            A character to convert to an integer digit
     * @param index
     *            The index of the character in the source
     * @return An integer
     * @throws DecoderException
     *             Thrown if ch is an illegal hex character
     */
    protected static int toDigit(final char ch, final int index) throws DecoderException {
        final int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new DecoderException("Illegal hexadecimal character " + ch + " at index " + index);
        }
        return digit;
    }
}