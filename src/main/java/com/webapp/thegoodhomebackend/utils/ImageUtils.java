package com.webapp.thegoodhomebackend.utils;


import org.apache.commons.io.FilenameUtils;

public class ImageUtils {

    public static String getMimeType(String filename) {
        String extension = FilenameUtils.getExtension(filename).toLowerCase();
        return switch (extension) {
            case "jpg", "jpeg" -> "image/jpeg";
            case "png" -> "image/png";
            default -> "application/octet-stream";
        };
    }
}
