package lesson7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FilesTest {

    @Test
    @DisplayName("Загрузка файла по абсолютному пути(не рекомендуется)")
    void fileNameShouldDisplayedAfterUploadActionAbsolutePathTest() {
        open("https://the-internet.herokuapp.com/upload");
       File exampleFile1 =  new File("C:\\Users\\Aleksandr\\Desktop\\Study\\QaGuru\\src\\test\\resources\\example");
        $("input[type='file']").uploadFile(exampleFile1);
        $("#file-submit").click();
        $("#uploaded-files").shouldHave(text("example"));
    }

    @Test
    @DisplayName("Загрузка файла по относительному пути(рекомендуется)")
    void fileNameShouldDisplayedAfterUploadActionFromClassPathTest() {
        open("https://the-internet.herokuapp.com/upload");
        $("input[type='file']").uploadFromClasspath("example");
        $("#file-submit").click();
        $("#uploaded-files").shouldHave(text("example"));
    }




}
