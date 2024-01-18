package ru.kinopoisk.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverProvider {
    private WebDriverConfig config;

    public WebDriverProvider(){
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        createDriver();
    }

    public void createDriver() {
        if (config.getBrowser().equalsIgnoreCase("chrome")) {
            Configuration.browser = "chrome";
        }
        if (config.getBrowser().equalsIgnoreCase("firefox")) {
            Configuration.browser = "firefox";
        }

        Configuration.baseUrl = config.getBaseUrl();
        Configuration.remote = config.getRemoteUrl();
        Configuration.browserVersion = config.getBrowserVersion();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
    }

}
