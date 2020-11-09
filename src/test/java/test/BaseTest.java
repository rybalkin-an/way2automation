package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Hack;
import helpers.ParametersProvider;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import io.qameta.allure.selenide.AllureSelenide;
import java.io.IOException;

@Listeners({ScreenShooter.class})
public class BaseTest {

    protected final String baseUrl;
    protected int indexForIframe;

    public BaseTest() throws IOException {
        baseUrl = ParametersProvider.getProperty("host");
    }

    @AfterMethod
    protected void tearDownMethod(){
        Selenide.closeWebDriver();
    }

    @Parameters("browserName")
    @BeforeMethod
    protected void Setup(@Optional("chrome") String browserName) throws IOException {
        indexForIframe = new Hack().getIndex(browserName);
        Configuration.startMaximized = true;
        Configuration.browser = browserName;
        Configuration.remote = ParametersProvider.getProperty("selenoidUrl");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        Configuration.browserCapabilities = capabilities;
    }
}

