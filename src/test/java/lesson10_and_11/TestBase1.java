package lesson10_and_11;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
//import io.qameta.allure.selenide.AllureSelenide;
import lesson10_and_11.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase1 {
    @BeforeAll
    static void setup() {
        //SelenideLogger.addListener("AllureSelenide", new AllureSelenide()); // отображает все методы в Allure
        Configuration.startMaximized = true; // разворачивает браузер во все экран
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";//запуск в селенойде(?)
        //Configuration.remote = "http://127.0.0.1:4444/wd/hub";//локальный селенойд
        Configuration.remote = "http://localhost:4444/wd/hub/";//локальный селенойд
        //подключаем для selenoid свойства
        DesiredCapabilities capabilities = new DesiredCapabilities(); // описывает дополнительные характеристики для Web driver при помощи пары ключ-значение
        capabilities.setCapability("enableVNC", true); // включаем картику работы на удалённом рабочем столе
        capabilities.setCapability("enableVideo", true); // включаем запись видео
        Configuration.browserCapabilities = capabilities;
    }
    @AfterEach
    public void teatDown(){
        Attach.screenshotAs("Last Screenshot");
        Attach.browserConsoleLogs();
        Attach.pageSource();
        Attach.addVideo();
    }
}
