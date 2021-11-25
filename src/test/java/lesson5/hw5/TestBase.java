package lesson5.hw5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    public static void settings(){
        Configuration.startMaximized=true;
        Configuration.holdBrowserOpen=true;
    }
}
