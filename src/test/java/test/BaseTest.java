package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.open;

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

}
