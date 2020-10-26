package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import helpers.ListenerTest;
import io.qameta.allure.selenide.AllureSelenide;
import static com.codeborne.selenide.Selenide.open;

@Listeners(ListenerTest.class)
public class BaseTest {

    protected final String baseUrl = "http://way2automation.com/";

    @BeforeMethod
    protected void setUpMethod(){
        open(baseUrl);
    }

    @AfterMethod
    protected void tearDownMethod(){
        Selenide.closeWebDriver();
    }

    @BeforeTest
    protected void Setup(){
        Configuration.startMaximized=true;
    }

    public WebDriver getDriver(){
        return WebDriverRunner.getWebDriver();
    }

}
