package lesson7;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FilesTest {

    @Test
    void fileNameShouldDisplayedAfterUploadActionTest() {
        open("https://the-internet.herokuapp.com/upload");
        $("input[type='file']").uploadFile();

    }

}
