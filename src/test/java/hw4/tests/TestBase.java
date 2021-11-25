package hw4.tests;

import com.codeborne.selenide.Configuration;
import hw4.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    RegistrationPage registrationPage=new RegistrationPage();

    @BeforeAll
    static void setting(){
        Configuration.startMaximized=true;
        Configuration.holdBrowserOpen=true;
    }
}
