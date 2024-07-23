package com.murilobarbosa.java.springboot.essentials.application.utils;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderUtils {

    private static final String BASE_PATH = "src/test/resources/json/%s";

    public static String getJson(String path) {
        return readJsonFile(String.format(BASE_PATH, path));
    }

    public static String readJsonFile(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            throw new RuntimeException("Error reading file", e);
        }
    }

}
