package hw3;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TestByGitHub {

    final SelenideElement openWiki =  $("#wiki-tab");
    final SelenideElement checkTitle = $(byText("Welcome to the selenide wiki!"));
    final SelenideElement showMore =  $(withText("Show 2 more pages"));
    final ElementsCollection pageSoftAssertion = $$(by("href", "/selenide/selenide/wiki/SoftAssertions"));
    final SelenideElement checkTitle2 =  $(byText("SoftAssertions"));
    final SelenideElement checkTextJunit =  $(".markdown-body");

    @BeforeAll
    public static void setting(){
        Configuration.startMaximized=true;
        Configuration.holdBrowserOpen=true;
    }

    @Test
    public void homeWorkByGitHub(){
        open("https://github.com/selenide/selenide");
        openWiki.click();
        checkTitle.shouldHave(visible);
        showMore.click();
        pageSoftAssertion.findBy(text("SoftAssertions")).click();
        checkTitle2.shouldHave(visible);
        checkTextJunit.shouldHave(text("JUnit5 extension"));
    }
}
