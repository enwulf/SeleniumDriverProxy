package ru.enwulf.drivers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.enwulf.extension.ExtensionFactory;
import ru.enwulf.proxy.ProxyConfigurer;
import ru.enwulf.proxy.ProxySettings;

import java.io.IOException;
import java.nio.file.Path;

public class FirefoxDriverProxy implements ProxyConfigurer {
    private ProxySettings settings;

    private final ExtensionFactory extensionFactory;

    private static final String MANIFEST_TEMPLATE_PATH = "firefox_extension/manifest";
    private static final String CODE_TEMPLATE_PATH = "firefox_extension/code";

    public FirefoxDriverProxy(ProxySettings settings) {
        this.settings = settings;
        this.extensionFactory = new ExtensionFactory();
    }

    @Override public void configure(RemoteWebDriver driver) {
        if (!(driver instanceof FirefoxDriver firefoxDriver))
            throw new IllegalArgumentException("Expected FirefoxDriver instance.");

        try {
            Path extensionPath = extensionFactory.generateExtension(settings, MANIFEST_TEMPLATE_PATH, CODE_TEMPLATE_PATH);
            firefoxDriver.installExtension(extensionPath, true);
        } catch (IOException e) {
            throw new RuntimeException("Error configuring proxy.", e);
        }
    }
}