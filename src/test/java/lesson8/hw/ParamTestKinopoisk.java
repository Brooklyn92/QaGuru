package lesson8.hw;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParamTestKinopoisk {

    @BeforeAll
    public static void set(){
        Configuration.startMaximized=true;
        Configuration.holdBrowserOpen=true;
    }
    @Test
    public void testKP(){
        open("https://www.kinopoisk.ru/");
        $(By.name("kp_query")).setValue("Аркейн").pressEnter();
        $(".block_left_pad").shouldHave(text("Аркейн (сериал)"));


    }
}
