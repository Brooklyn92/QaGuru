package lesson8;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @CsvSource( value = {
            "Selenide | лаконичные и стабильные UI тесты на Java",
            "Allure | Beauty Tips, Trends & Product Reviews"
    },
    delimiter = '|') //  метод delimiter делит стрингу на два и более входных параметра.
    @Tag("higth")
    @DisplayName("Search in Yandex")
    @ParameterizedTest(name = "Search in ya.ru words {0} и проверка отображения текста {1}") //в {} прописывается индекс параметра. Параметр search имеет индекс 0
    void CommonYaSearchTest(String search, String expectedResult) {
        //String[] strings = search.split("_");//split - разделяет строку на подстроки используя разделитель,
                                                  // который определяется с помощью регулярного выражения.
                                                  //Строка "Selenide_лаконичные и стабильные UI тесты на Java" будет иметь вид "Selenide", "лаконичные и стабильные UI тесты на Java".

        open("https://ya.ru/");
        $("#text").setValue(search);
        $("#text").pressEnter();
        $$("#search-result").shouldHave(texts(expectedResult));
    }
}
