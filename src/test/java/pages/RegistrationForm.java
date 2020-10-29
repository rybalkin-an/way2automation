package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationForm {

    private final SelenideElement nameField = $x("//input[@name='name']");
    private final SelenideElement phoneField = $x("//input[@name='phone']");
    private final SelenideElement emailField = $x("//input[@name='email']");
    private final SelenideElement countryField = $x("//select[@name='country']");
    private final SelenideElement cityField = $x("//input[@name='city']");
    private final SelenideElement userNameField = $x("//div[@id='load_box']//input[@name='username']");
    private final SelenideElement passwordField = $x("//div[@id='load_box']//input[@name='password']");
    private final SelenideElement submitButton = $x("//div[@id='load_box']//input[@class='button' and @value='Submit']");

    @Step("Заполнение обязательного поля 'Email:'")
    public RegistrationForm emailFieldSendKeys(String email) {
        emailField.sendKeys(email);
        return this;
    }

    @Step("Заполнение обязательного поля 'Name:'")
    public RegistrationForm nameFieldSendKeys(String name) {
        nameField.sendKeys(name);
        return this;
    }

    @Step("Заполнение обязательного поля 'Phone:'")
    public RegistrationForm phoneFieldSendKeys(String phone) {
        phoneField.sendKeys(phone);
        return this;
    }

    @Step("Заполнение обязательного поля 'City:'")
    public RegistrationForm cityFieldSendKeys(String city) {
        cityField.sendKeys(city);
        return this;
    }

    @Step("Заполнение обязательного поля 'Username:'")
    public RegistrationForm usernameFieldSendKeys(String username) {
        userNameField.sendKeys(username);
        return this;
    }

    @Step("Заполнение обязательного поля 'Password:'")
    public RegistrationForm passwordFieldSendKeys(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Выбор страны в списке 'Country:'")
    public RegistrationForm selectCountry(String country) {
        countryField.selectOptionByValue(country);
        return this;
    }

    @Step("Нажатие на кнопку 'Submit'")
    public RegistrationForm submitButtonClick() {
        submitButton.click();
        return this;
    }

}
