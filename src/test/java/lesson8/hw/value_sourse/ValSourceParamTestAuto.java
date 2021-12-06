package lesson8.hw.value_sourse;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class ValSourceParamTestAuto {

    @BeforeAll
    public static void set(){
        Configuration.startMaximized=true;
        Configuration.holdBrowserOpen=true;
    }


  @ValueSource(strings = {
            "Аркейн_Аркейн (сериал)",
            "Во все теяжкие_Во все тяжкие (сериал)"
  })
  @Tag("hight")
  @DisplayName("Поиск на сайте Kinopoisk")
  @ParameterizedTest(name = "Ищем сериалы в кинопоиске {0} и проверка отображения заголова серила {1}")
    public void testKP(String film){
        String[] strings = film.split("_");
        open("https://www.kinopoisk.ru/");
        $(byName("kp_query")).setValue(strings[0]).pressEnter();
        $$(".block_left_pad").shouldHave(CollectionCondition.texts(strings[1]));

    }
}