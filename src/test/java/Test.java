import org.openqa.selenium.firefox.FirefoxDriver;
import ru.enwulf.proxy.ProxyProtocol;
import ru.enwulf.proxy.ProxySettings;
import ru.enwulf.drivers.FirefoxDriverProxy;

public class Test {
    public static void main(String[] args) {

        ProxySettings settings = new ProxySettings(ProxyProtocol.HTTP, "...", 8081);
        settings.setUsername("alZK1qk");
        settings.setPassword("qoKzGGg");

        FirefoxDriverProxy proxy = new FirefoxDriverProxy(settings);

        FirefoxDriver driver = new FirefoxDriver();
        proxy.configure(driver);

        driver.get("https://www.ident.me/");
    }
}
