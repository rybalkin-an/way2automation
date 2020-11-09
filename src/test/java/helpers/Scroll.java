package helpers;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class Scroll {

    @Step("Выполнение скролла до элемента")
    public void intoView(SelenideElement selenideElement) {
        String js = "arguments[0].scrollIntoView(true);";
        Selenide.executeJavaScript(js, selenideElement);
    }

    @Step("Проверка наличия вертикального скроллбара")
    public Boolean hasVerticalScroll(){
        String js = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
        return Selenide.executeJavaScript(js);
    }

    @Step("Проверка наличия горизонтального скроллбара")
    public Boolean hasHorizontalScroll(){
        String js = "return document.documentElement.scrollWidth>document.documentElement.clientWidth;";
        return Selenide.executeJavaScript(js);
    }

}
