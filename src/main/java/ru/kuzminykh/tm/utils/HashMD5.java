package ru.kuzminykh.tm.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashMD5 {

    public static String getHash(String strInput) {
        try {
            byte[] bytesOfMessage = strInput.getBytes(StandardCharsets.UTF_8);
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(bytesOfMessage);
            return new BigInteger(1, digest).toString(16);
        }
        catch (NoSuchAlgorithmException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

}
