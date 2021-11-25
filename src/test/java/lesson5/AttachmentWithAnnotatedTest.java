package lesson5;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Attachment;
import lesson5.steps.WebSteps;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AttachmentWithAnnotatedTest extends TestBase {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private WebSteps steps=new WebSteps();

    @Test
    public void testAnnotated(){
            steps.openMainPage();
            steps.searchForRepository(REPOSITORY);
            steps.takeScreenshot();
    }

    private byte[] getScreenshot(){
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    }
}
