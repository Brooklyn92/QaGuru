package lesson8;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;

public class YaTest {
    @BeforeAll
    public static void set(){
        Configuration.startMaximized=true;
    }

    @DisplayName("Поиск в ya.ru слова Selenide")
    @Tag("higth")
    @Test
    void selenideSearchTest() {
        open("https://ya.ru/");
        $("#text").setValue("Selenide");
        $("#text").pressEnter();
        $$("#search-result").shouldHave(texts("лаконичные и стабильные UI тесты на Java"));
    }

    /* @ValueSource(strings = {
            "Selenide_лаконичные и стабильные UI тесты на Java",
            "Allure_Beauty Tips, Trends & Product Reviews"
    })//прописываются параметры. Тест будет пройден столько раз, сколько указано параметров
     */
    /*
    @CsvSource( value = {
            //"Selenide | лаконичные и стабильные UI тесты на Java",
            //"Allure | Beauty Tips, Trends & Product Reviews"
            "Selenide | SELENIDE", // передаём значения ENUM
            "Allure | ALLURE"
    },
    delimiter = '|') //  метод delimiter делит стрингу на два и более входных параметра.
     */
    //@EnumSource(SearchQuery.class) // позволяет параметризовать тесты по Enum.

    static Stream<Arguments> CommonYaSearchTest(){
        return Stream.of(
                Arguments.of("Selenide", List.of("лаконичные и стабильные UI тесты на Java")),
                Arguments.of("Allure", List.of("Beauty Tips, Trends & Product Reviews"))
        );
    }

    @MethodSource
    @Tag("higth")
    @DisplayName("Search in Yandex")
    @ParameterizedTest(name = "Search in ya.ru words {0} и проверка отображения текста {1}")  //в {} прописывается индекс параметра. Параметр search имеет индекс 0
    void CommonYaSearchTest(String search, List<String> expectedResult) { //в качестве параметра можно указывать имя класса Enum.
        //String[] strings = search.split("_");//split - разделяет строку на подстроки используя разделитель,
        // который определяется с помощью регулярного выражения.
        //Строка "Selenide_лаконичные и стабильные UI тесты на Java" будет иметь вид "Selenide", "лаконичные и стабильные UI тесты на Java".
        open("https://ya.ru/");
        $("#text").setValue(search);
        $("#text").pressEnter();
        $$("#search-result").shouldHave(texts(expectedResult.get(0)));//get(0) получить первую запись
    }
}

