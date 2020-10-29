package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement quickContactField = $x("//section[@style=\"visibility: visible; animation-duration: 2s; animation-name: bounceInRight;\"]");
    private final ElementsCollection coursesSection = $$x("//section[@class='section-default'][1]//div[@class='posts-wrap']//article");

    @Step("Ожидание загрузки Quick Contact формы")
    public QuickContactForm waitLoadingQuickContactForm() {
        quickContactField.waitUntil(Condition.visible, 4500);
        switchTo().frame(2);
        return new QuickContactForm();
    }

    @Step("Проскролить страницу до кусров")
    public ElementsCollection getCourseSectionById() {
        coursesSection.get(0).scrollIntoView(false);
        return coursesSection;
    }

}
