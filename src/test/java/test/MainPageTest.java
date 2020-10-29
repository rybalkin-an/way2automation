package test;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.QuickContactForm;
import helpers.ParametersProvider;
import java.io.IOException;
import static com.codeborne.selenide.Selenide.open;

@Epic("Тестирование главной страницы http://way2automation.com/")
public class MainPageTest extends BaseTest{

    private final MainPage mainPage;
    private final QuickContactForm quickContactForm;

    public MainPageTest() {
        mainPage = new MainPage();
        quickContactForm = new QuickContactForm();
    }

    @DataProvider(name = "notValidEmail")
    private Object[][] dataProviderMethod() {

        return new Object[][] {
                {"testEmail", "full Name", "123456789012", "comment"},
                {"testEmailWithoutDomain@", "", "123456789012", "1231231"},
                {"testEmailWith2@@test.ru", "1231414", "", "1%$%^&*()!"},
                {"", "Short", "qweqw", ""},
        };
    }

    @BeforeMethod
    protected void setUpMethod(){
        open(baseUrl);
    }

    @Test(dataProvider = "notValidEmail", description = "[Negative] При отправке 'Quick Contact' формы с " +
            "невалидной электронной почтой, появляется сообщение 'Укажите действительный адрес эл. почты'")
    public void testQuickContactFormWithNotValidEmail(String email, String fullName,
                                                      String phoneNumber, String comment) {
        mainPage.waitLoadingQuickContactForm();
        quickContactForm
                .fillUpEmail(email)
                .fillUpCommentsField(comment)
                .fillUpFullName(fullName)
                .fillUpPhoneNumber(phoneNumber)
                .clickSubmitButton();

        quickContactForm
                .getEmailFieldErrorMessage()
                .shouldHave(Condition.visible);
    }

    @Test(description = "[Positive] отображается секция 'Courses' с курсами SELENIUM, APPIUM, PROTRACTOR и JMETER")
    public void testCoursesSection() throws IOException {
        mainPage.getCourseSectionById().get(0)
                .shouldHave(Condition.text(ParametersProvider.getProperty("selenium")));
        mainPage.getCourseSectionById().get(1)
                .shouldHave(Condition.text(ParametersProvider.getProperty("appium")));
        mainPage.getCourseSectionById().get(2)
                .shouldHave(Condition.text(ParametersProvider.getProperty("protracor")));
        mainPage.getCourseSectionById().get(3)
                .shouldHave(Condition.text(ParametersProvider.getProperty("jmeter")));
        }
}
