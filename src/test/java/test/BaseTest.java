package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import io.qameta.allure.selenide.AllureSelenide;


@Listeners({ScreenShooter.class})
public class BaseTest {

    protected final String baseUrl = "http://way2automation.com/";

    @AfterMethod
    protected void tearDownMethod(){
        Selenide.closeWebDriver();
    }

    @BeforeTest
    protected void Setup(){
        Configuration.startMaximized=true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }
}
