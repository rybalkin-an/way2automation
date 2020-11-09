package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class MenuPage {
    private final SelenideElement menuWidget = $x("//ul[@class='boxed_style block']//a[@href='menu.php']");
    private final SelenideElement menuWithSubMenu = $x("//a[@href='#example-1-tab-2']");
    private final SelenideElement adamsville = $("#ui-id-2");

    public void goToMenuPage() {
        menuWidget.click();
    }

    public void clickOnMenuWithSubMenu() {
        menuWithSubMenu.click();
        switchTo().frame(1);
        adamsville.click();
    }

}
