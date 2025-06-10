package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBaseHW12 {

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeAll
    static void installСonfiguration() {
        String browser = System.getProperty("browser", "chrome");
        String browserVersion = System.getProperty("browserVersion", "127.0");
        String screenResolution = System.getProperty("screenResolution", "1920x1080");

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = screenResolution;
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
        Configuration.remote = String.format(
                "https://%s:%s@%s/wd/hub",
                System.getProperty("selenoidUserLogin", "user1"),
                System.getProperty("selenoidUserPassword", "1234"),
                System.getProperty("selenoidUrl", "selenoid.autotests.cloud")
        );


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        helpers.Attach.screenshotAs("Last screenshot");
        helpers.Attach.pageSource();
        helpers.Attach.browserConsoleLogs();
        helpers.Attach.addVideo();
    }
}