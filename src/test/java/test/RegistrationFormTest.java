package test;

import com.codeborne.selenide.WebDriverRunner;
import helpers.CookieManager;
import io.qameta.allure.Epic;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegistrationForm;
import java.io.IOException;
import java.util.Set;
import static com.codeborne.selenide.Selenide.open;

@Epic("Тестирование формы регистрации http://way2automation.com/way2auto_jquery/index.php")
public class RegistrationFormTest extends BaseTest {

    private final String path = "way2auto_jquery/index.php";
    private final String userName = RandomStringUtils.randomAlphanumeric(8);
    private final String password = RandomStringUtils.randomAlphanumeric(8);
    private final String name = RandomStringUtils.randomAlphanumeric(8);
    private final CookieManager cookieManager;
    private Set<Cookie> cookieSet;

    public RegistrationFormTest() throws IOException {
        super();
        cookieManager = new CookieManager();
    }

    @BeforeMethod(description = "Открытие страницы http://way2automation.com/way2auto_jquery/index.php")
    public void setUpMethod() {
        open(baseUrl + path);
    }

    @Test(description = "Заполнение формы регистрации и сохранение кукисов сессии в файл")
    public void testRegistrationForm() {
        new RegistrationForm()
                .cityFieldSendKeys("SamaraCity")
                .emailFieldSendKeys(name + "@mail.com")
                .nameFieldSendKeys(name)
                .passwordFieldSendKeys(password)
                .selectCountry("Russia")
                .usernameFieldSendKeys(userName)
                .phoneFieldSendKeys("+79999999999")
                .submitButtonClick();
        cookieSet = cookieManager.getCookiesFromWebDriver();
        cookieManager.writeToFile(cookieSet);

        Assert.assertEquals(WebDriverRunner.getWebDriver().manage().getCookies().size(), 2);
    }

    @Test(description = "Провекра работоспособности сохранненых кукисов")
    public void testLoginWithCookie() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        driver.manage().deleteAllCookies();
        cookieSet = cookieManager.getCookiesFromFile();
        for (Cookie cookie : cookieSet) {
            driver.manage().addCookie(cookie);
        }
        driver.navigate().refresh();

        Assert.assertNotNull(driver.manage().getCookieNamed("__zlcmid"));
        Assert.assertNotNull(driver.manage().getCookieNamed("PHPSESSID"));
    }

}
