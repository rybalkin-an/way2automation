package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement quickContactField = $x("//section[@style=\"visibility: visible; animation-duration: 2s; animation-name: bounceInRight;\"]");
    private final ElementsCollection coursesSection = $$x("//section[@class='section-default'][1]//div[@class='posts-wrap']//article");
    private final SelenideElement subscribeField = $x("//input[@class='subscribe__input form-control']");

    @Step("Ожидание загрузки Quick Contact формы")
    public QuickContactForm waitLoadingQuickContactForm(int index) {
        quickContactField.waitUntil(Condition.visible, 5500);
        switchTo().frame(index);
        return new QuickContactForm();
    }

    @Step("Проскролить страницу до секции с курсами и получить элемент coursesSection")
    public ElementsCollection getCourseSectionAndScrollIntoView() {
        coursesSection.get(0).scrollIntoView(false);
        return coursesSection;
    }

    @Step("Получить элемент subscribeField")
    public SelenideElement getSubscribeField() {
        return subscribeField;
    }


    @Step("Кликнуть за границей элемента")
    public MainPage clickOutOfElement(SelenideElement selenideElement) {
        Selenide.actions()
                .moveToElement(selenideElement, 100, 0)
                .click()
                .build()
                .perform();
        return this;
    }

}
