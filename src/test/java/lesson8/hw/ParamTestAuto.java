package lesson8.hw;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class ParamTestAuto {

    @BeforeAll
    public static void set(){
        Configuration.startMaximized=true;
        Configuration.holdBrowserOpen=true;
    }

  @ParameterizedTest(name = "Ищем сериалы в кинопоиске {0} и проверка отображения заголова серила {1}")
   @CsvSource( value = {
           "Аркейн | Аркейн (сериал)",
           "Во все тяжкие | Во все тяжкие (сериал)"
   },
        delimiter = '|')
  @Tag("hight")
  @DisplayName("Поиск на сайте Kinopoisk")
    public void testKP(String film, String title){
        open("https://www.kinopoisk.ru/");
        $(byName("kp_query")).setValue(film).pressEnter();
        $$(".block_left_pad").shouldHave(CollectionCondition.texts(title));

    }
}