package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.QuickContactForm;

public class MainPageTest extends BaseTest{

    private final String email = "testEmail";
    private final String fullName = "Test Testerov";
    private final String phoneNumber = "123456789012";
    private final String comment = "comment";

    @DataProvider(name = "notValidEmail")
    private Object[][] dataProviderMethod() {
        return new Object[][] {
                {email, fullName, phoneNumber, comment},
                {"testEmailWithoutDomain@", "", phoneNumber, "1231231"},
                {"testEmailWith2@@test.ru", "1231414", "", "1%$%^&*()!"},
                {"", "Short", "qweqw", ""},
        };
    }

    @Test(dataProvider = "notValidEmail", description = "[Negative] При отправке 'Quick Contact' формы с " +
            "невалидной электронной почтой, появляется сообщение 'Укажите действительный адрес эл. почты'")
    private void testQuickContactFormWithNotValidEmail(String email,
                                                      String fullName,
                                                      String phoneNumber,
                                                      String comment) {
        new MainPage().waitLoadingQuickContactForm();
        new QuickContactForm()
                .fillUpEmail(email)
                .fillUpCommentsField(comment)
                .fillUpFullName(fullName)
                .fillUpPhoneNumber(phoneNumber)
                .clickSubmitButton()
                .emailFieldErrorMessageIsDisplayed();
    }

    @Test(description = "[Positive] отображается секция 'Courses' с курсами SELENIUM, APPIUM, PROTRACTOR и JMETER")
    private void testCoursesSection() {
        MainPage mainPage = new MainPage();
        String selenium = mainPage.getCourseSectionById().get(0).getText();
        String appium = mainPage.getCourseSectionById().get(1).getText();
        String protractor = mainPage.getCourseSectionById().get(2).getText();
        String jmeter = mainPage.getCourseSectionById().get(3).getText();

        Assert.assertEquals(selenium, "SELENIUM\nSelenium is an open source automation testing tool for web based applications. It runs directly on a web browser such as Firefox, chrome, IE, Opera, Safari etc., and supports...");
        Assert.assertEquals(appium, "APPIUM\nAppium is the most demanding Mobile application automation testing tool that can automate all types of Native, Hybrid and Webapp on Real Iphone / Android Devices and Simulators...");
        Assert.assertEquals(protractor, "PROTRACTOR\nLearn and master all advance concepts on Protracor which are require to automate AngularJS and non angular applications. The tool itself is in high demand in market get Life time support in your queries...");
        Assert.assertEquals(jmeter, "JMETER\nEver thought of getting live experience on Performance testing of Webapps in any training course? Yes its possible now, with W2A you will learn all advance concepts of Performance...");
    }

}
