package lesson8.hw.method_source;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class ParamMethodSTestAuto {

    @BeforeAll
    public static void set(){
        Configuration.startMaximized=true;
        Configuration.holdBrowserOpen=true;
    }

    static Stream<Arguments> testKP() {
        return Stream.of(
                Arguments.of("Аркейн", List.of("Аркейн (сериал)")),
                Arguments.of("Во все тяжкие", List.of("Во все тяжкие (сериал)"))
        );
    }

  @ParameterizedTest(name = "Ищем сериалы в кинопоиске {0} и проверка отображения заголова серила {1}")
  @MethodSource
  @Tag("hight")
  @DisplayName("Поиск на сайте Kinopoisk")
    public void testKP(String film, List<String> title){
        open("https://www.kinopoisk.ru/");
        $(byName("kp_query")).setValue(film).pressEnter();
        $$(".block_left_pad").shouldHave(texts(title.get(0)));

    }
}