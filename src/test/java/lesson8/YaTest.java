package lesson8;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;

public class YaTest {

    @DisplayName("Поиск в ya.ru слова Selenide")
    @Tag("higth")
    @Test
    void selenideSearchTest() {
        open("https://ya.ru/");

    }
}

