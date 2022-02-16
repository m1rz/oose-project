package com.mad;

import java.security.MessageDigest;

public class CryptographyService {

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static String getHash(String plaintext) {
        String hash = null;
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            final byte[] hashedBytes = digest.digest(plaintext.getBytes("UTF-8"));
            hash = bytesToHex(hashedBytes);
        } catch (Exception e) {
            System.out.println("Failed to get cryptography service.\n\n" + e.getMessage());
        }
        return hash;
    }
}
