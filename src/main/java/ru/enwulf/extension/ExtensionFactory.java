package ru.enwulf.extension;

import ru.enwulf.proxy.ProxyProtocol;
import ru.enwulf.proxy.ProxySettings;
import ru.enwulf.utils.FileUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class ExtensionFactory {

    private static final String EXTENSION_PATH = "proxy_.xpi";

    private static final String MANIFEST_FILE_PATH = "manifest.json";
    private static final String BACKGROUND_FILE_PATH = "background.js";

    public Path generateExtension(ProxySettings settings, String manifestTemplatePath, String codeTemplatePath) throws IOException {
        String manifestContent = generateManifest(manifestTemplatePath);
        String backgroundContent = generateProxyCode(codeTemplatePath, settings.getProtocol(), settings.getHost(), settings.getPort(), settings.getUsername(), settings.getPassword());

        try {
            FileUtils.writeToFile(manifestContent, MANIFEST_FILE_PATH);
            FileUtils.writeToFile(backgroundContent, BACKGROUND_FILE_PATH);
            FileUtils.createZipArchive(EXTENSION_PATH, MANIFEST_FILE_PATH, BACKGROUND_FILE_PATH);
            return Paths.get(EXTENSION_PATH);
        } finally {
            FileUtils.deleteFile(MANIFEST_FILE_PATH);
            FileUtils.deleteFile(BACKGROUND_FILE_PATH);
        }
    }

    private String generateManifest(String manifestTemplatePath) {
        return FileUtils.readResourceFile(manifestTemplatePath);
    }

    private String generateProxyCode(String codeTemplatePath, ProxyProtocol protocol, String host, int port,
                                     String username, String password) {
        String template =  FileUtils.readResourceFile(codeTemplatePath);
        return String.format(Objects.requireNonNull(template), protocol.getName(), host, port, username, password);
    }
}