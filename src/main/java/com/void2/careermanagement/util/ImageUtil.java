package com.void2.careermanagement.util;

import java.util.Base64;

public class ImageUtil {
    public static String encodeToBase64(byte[] imageBytes) {
        if(imageBytes == null) return "";
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}