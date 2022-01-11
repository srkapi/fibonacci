package com.srkapi.base;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@UtilityClass
public class FileHelper {
    public String getContentFromFile(String requestFileName) throws IOException {
        Path filePath = Paths.get("src", "test", "resources", "request", requestFileName);
        return Files.readString(filePath);
    }

    public String getContentFromFile(String requestFileName, String baseUrl) throws IOException {
        return String.format(getContentFromFile(requestFileName), baseUrl);
    }

}
