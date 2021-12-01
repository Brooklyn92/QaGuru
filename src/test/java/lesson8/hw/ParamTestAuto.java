package lesson8.hw;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParamTestAuto {

    @BeforeAll
    public static void set(){
        Configuration.startMaximized=true;
        Configuration.holdBrowserOpen=true;
    }
    @Test
    public void testRiot(){
        open("https://arcane.com/ru-ru/");
        $("#riotbar-right-content").shouldHave(text("Вход")).click();
        $(byName("username")).setValue("Riot73");
        $(byName("password")).setValue("Riot73");
        $("button[type='submit']").click();
    }
}
