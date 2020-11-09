package test;

import com.codeborne.selenide.SelenideElement;
import helpers.Scroll;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import java.io.IOException;
import static com.codeborne.selenide.Selenide.*;

@Epic("Scrollbar testing")
public class ScrollTest extends BaseTest{

    public ScrollTest() throws IOException {
        super();
    }

    @BeforeMethod(description = "Открытие страницы http://way2automation.com/")
    public void setUpMethod() {
        open(baseUrl);
    }

    @Test(
            description = "1) Проскроллить сайд до секции Subscribe for free tutorials: " +
                          "2) проскроллить до секции с курсами")
    public void scrollTest() {
        MainPage mainPage = new MainPage();
        SelenideElement subscribeField = mainPage.getSubscribeField();
        subscribeField.scrollIntoView(false).sendKeys("checked");
        mainPage.clickOutOfElement(subscribeField);
        mainPage.getCourseSectionAndScrollIntoView();

        Scroll scroll = new Scroll();
        Assert.assertTrue(scroll.hasVerticalScroll());
        Assert.assertFalse(scroll.hasHorizontalScroll());
    }

}
