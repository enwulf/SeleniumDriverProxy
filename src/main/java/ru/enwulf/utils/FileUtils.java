package ru.enwulf.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtils {

    public static void writeToFile(String content, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

    public static void createZipArchive(String archiveName, String... files) {
        Path zipFilePath = Paths.get(archiveName);
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFilePath))) {
            for (String file : files) {
                Path filePath = Paths.get(file);
                ZipEntry zipEntry = new ZipEntry(filePath.getFileName().toString());
                zipOutputStream.putNextEntry(zipEntry);
                Files.copy(filePath, zipOutputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String filePath) {
        try {
            Files.deleteIfExists(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readResourceFile(String fileName) {
        ClassLoader classLoader = FileUtils.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream(fileName);
        if (is != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                return reader.lines()
                        .collect(Collectors.joining("\n"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Resource not found: " + fileName);
        }

        return null;
    }
}