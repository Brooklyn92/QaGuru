package lesson5.hw5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubAllureListener extends TestBase {
    private static String issue="Get web console logs from firefox";
    private static Integer issueNumber=1636;

    @Test
    public void testingGitHub(){
        //Подключаем Listener
        SelenideLogger.addListener("allure", new AllureSelenide());
        //Открываем главную страницу в GitHub
        open("https://github.com/");
        //Клиекаем по полю поиска
        $(".header-search-input").click();
        //Пишем в строку поиска selenide/selenide
        $(".header-search-input").sendKeys("selenide/selenide");
        //Осуществляем  поиск значения selenide/selenide
        $(".header-search-input").submit();
        //Осуществяем переход в репозиторий selenide/selenide
        $(By.linkText("selenide/selenide")).click();
        // Проверяем, что есть вкладка Issues
        $("#issues-tab").should(Condition.visible);
        //Переходим во вкладку Issues
        $("#issues-tab").click();
        //Проверка на то, что существует задача "Get web console logs from firefox" и её номер 1636
        $("#issue_1636").should(Condition
                .text(issue)).should(Condition.visible)
                .should(Condition.text("#"+issueNumber))
                .should(Condition.visible);

    }
}
