import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lesson10_and_11.TestBase1;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TestSelenoidAndJenkins extends TestBase1 {

    final SelenideElement openWiki =  $("#wiki-tab");
    final SelenideElement checkTitle = $(byText("Welcome to the selenide wiki!"));
    final SelenideElement showMore =  $(withText("Show 2 more pages"));
    final ElementsCollection pageSoftAssertion = $$(by("href", "/selenide/selenide/wiki/SoftAssertions"));
    final SelenideElement checkTitle2 =  $(byText("SoftAssertions"));
    final SelenideElement checkTextJunit =  $(".markdown-body");

    @Test
    public void homeWorkByGitHub(){
        open("https://github.com/selenide/selenide");
        openWiki.click();
        checkTitle.shouldHave(visible);
        showMore.click();
        pageSoftAssertion.findBy(text("SoftAssertions")).click();
        checkTitle2.shouldHave(visible);
        checkTextJunit.shouldHave(text("JUnit5 extension"));
        Selenide.sleep(10000);
    }

}
