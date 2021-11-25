package lesson5;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import lesson5.steps.WebSteps;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AttachmentTest extends TestBase {

    private static final String REPOSITORY = "eroshenkoam/allure-example";

    @Test
    public void testLambda() {
        AllureLifecycle lifecycle=Allure.getLifecycle();
        step("Открываем главную страницу",() -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
            lifecycle.addAttachment("Screenshot","image/png","png", takeScreenshot());
        });

    }

    private byte[] takeScreenshot(){
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    }
}
