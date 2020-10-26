package pages;

import com.codeborne.selenide.SelenideElement;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement quickContactField = $x("//section[@style=\"visibility: visible; animation-duration: 2s; animation-name: bounceInRight;\"]");
    private final List<SelenideElement> coursesSection = $$x("//section[@class='section-default'][1]//div[@class='posts-wrap']//article");

    public Class<QuickContactForm> waitLoadingQuickContactForm() {
        quickContactField.isDisplayed();
        switchTo().frame(2);
        return QuickContactForm.class;
    }

    public List<SelenideElement> getCourseSectionById() {
        coursesSection.get(0).scrollIntoView(false);
        return coursesSection;
    }

}
