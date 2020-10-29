package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;

public class QuickContactForm {

    private final SelenideElement emailField = $x("//div[@class='freebirdFormviewerViewFormContent']//input[@type='email']");
    private final SelenideElement fullNameField = $x("//div[contains(@data-params,'Full Name')]//input");
    private final SelenideElement phoneNumberField = $x("//div[contains(@data-params,'Phone number')]//input");
    private final SelenideElement commentsField = $x("//div[contains(@data-params,'Comments')]//textarea");
    private final SelenideElement emailFieldErrorMessage = $x("//div[@id='i3']");
    private final SelenideElement submitButton = $x("//span[@class='appsMaterialWizButtonPaperbuttonLabel" +
            " quantumWizButtonPaperbuttonLabel exportLabel']");

    @Step("Заполнение обязательного поля 'Адрес электронной почты *'")
    public QuickContactForm fillUpEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    @Step("Заполнение обязательного поля 'Full Name *'")
    public QuickContactForm fillUpFullName(String fullName) {
        fullNameField.sendKeys(fullName);
        return this;
    }

    @Step("Заполнение обязательного поля 'Phone number *'")
    public QuickContactForm fillUpCommentsField(String comments) {
        commentsField.sendKeys(comments);
        return this;
    }

    @Step("Заполнение обязательного поля 'Адрес электронной почты *'")
    public QuickContactForm fillUpPhoneNumber(String phoneNumber) {
        phoneNumberField.sendKeys(phoneNumber);
        return this;
    }

    @Step("Получение сообщения об ошибке")
    public SelenideElement getEmailFieldErrorMessage(){
        return emailFieldErrorMessage;
    }

    @Step("Нажатие кнопки 'Submit'")
    public QuickContactForm clickSubmitButton(){
        submitButton.click();
        return this;
    }
}
