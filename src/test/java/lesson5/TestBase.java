package lesson5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    public static void setting(){
        Configuration.startMaximized=true;
        Configuration.holdBrowserOpen=true;
    }
}
