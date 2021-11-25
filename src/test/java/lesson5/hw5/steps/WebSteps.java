package lesson5.hw5.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openPageGitHub() {
        open("https://github.com/");
    }

    @Step("Ищем репозитоий {repository}")
    public void searchRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Проверяем наличие вкладки Issue")
    public void checkTabIssue() {
        $("#issues-tab").should(Condition.visible);
    }

    @Step("Переходим во вкладку Issue")
    public void goTabIssue() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие заголовка задачи и его номера")
    public void checkInTabIssueNameRepositoryAndNumber( String issueName, int issueNumber) {
        $("#issue_1636").should(Condition
                        .text(issueName)).should(Condition.visible)
                        .should(Condition.text("#"+issueNumber))
                        .should(Condition.visible);
    }

    @Attachment(value="Screenshot", type="image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
