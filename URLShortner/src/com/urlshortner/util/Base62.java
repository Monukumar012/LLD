package com.urlshortner.util;

public final class Base62 {
    private static final char[] CHARS =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private static final long ENCODE_MIN_LENGTH = 4;
    public static String encode(Long num) {
        StringBuilder encodeStr = new StringBuilder();
        while(num > 0) {
            int mod = (int) (num % 62);
            encodeStr.append(CHARS[mod]);
            num /= 62;
        }
        while(encodeStr.length() < ENCODE_MIN_LENGTH) {
            encodeStr.append(CHARS[0]);
        }
        return encodeStr.toString();
    }
}