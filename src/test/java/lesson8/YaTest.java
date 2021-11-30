package lesson8;
import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;

public class YaTest {

    @DisplayName("Поиск в ya.ru слова Selenide")
    @Tag("higth")
    @Test
    void selenideSearchTest() {
        open("https://ya.ru/");
        $("#text").setValue("Selenide");
        $("#text").pressEnter();
        $$("#search-result").shouldHave(texts("Selenide"));
    }

    @ValueSource(strings = {"Selenide","Allure"})//прописываются параметры. Тест будет пройден столько раз, сколько указано параметров
    @Tag("higth")
    @DisplayName("Search in Yandex")
    @ParameterizedTest(name = "Search in ya.ru word {0}") //в {} прописывается индекс параметра. Параметр search имеет индекс 0
    void CommonYaSearchTest(String search) {
        open("https://ya.ru/");
        $("#text").setValue(search);
        $("#text").pressEnter();
        $$("#search-result").shouldHave(texts(search));
    }
}

