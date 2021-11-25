package lesson5.hw5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GitHubAllureSteps extends TestBase {
    private static String issue="Get web console logs from firefox";
    private static Integer issueNumber=1636;

    @Test
    public void testingGitHub(){
        step("Открываем главную страницу в GitHub",() ->{
            open("https://github.com/");
        });

        step("Клиекаем по полю поиска",() -> {
            $(".header-search-input").click();
        });

        step("Пишем в строку поиска selenide/selenide", () -> {
            $(".header-search-input").sendKeys("selenide/selenide");
        });

        step("Осуществляем  поиск значения selenide/selenide", () -> {
            $(".header-search-input").submit();
        });

        step("Осуществяем переход в репозиторий selenide/selenide", () -> {
            $(By.linkText("selenide/selenide")).click();
        });

        step("Проверяем, что есть вкладка Issues", () -> {
            $("#issues-tab").should(Condition.visible);
        });

        step("Переходим во вкладку Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверка на то, что существует задача 'Get web console logs from firefox' и её номер 1636", () -> {
            $("#issue_1636").should(Condition
                            .text(issue)).should(Condition.visible)
                            .should(Condition.text("#"+issueNumber))
                            .should(Condition.visible);
        });

    }
}
