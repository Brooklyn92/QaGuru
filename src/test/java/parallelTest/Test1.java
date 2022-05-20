package parallelTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Test1 {

    private WebDriver driver;

    @BeforeEach
    public void start() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub/"), options);
        driver.get("https://yandex.ru");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testParallel1() throws InterruptedException {
        Thread.sleep(10000);
        Assertions.assertEquals(10, 5+5);
    }

    @Test
    public void testParallel2() throws InterruptedException {
        Thread.sleep(10000);
        Assertions.assertEquals(10, 5+5);
    }

    @Test
    public void testParallel3() throws InterruptedException {
        Thread.sleep(10000);
        Assertions.assertEquals(10, 5+5);
    }

    @Test
    public void testParallel4() throws InterruptedException {
        Thread.sleep(10000);
        Assertions.assertEquals(10, 5+5);
    }
    
    @Test
    public void testParallel5() throws InterruptedException {
        Thread.sleep(10000);
        Assertions.assertEquals(10, 5+5);
    }

    @Test
    public void testParallel6() throws InterruptedException {
        Thread.sleep(10000);
        Assertions.assertEquals(10, 5+5);
    }

    @Test
    public void testParallel7() throws InterruptedException {
        Thread.sleep(10000);
        Assertions.assertEquals(10, 5+5);
    }

    @Test
    public void testParallel8() throws InterruptedException {
        Thread.sleep(10000);
        Assertions.assertEquals(10, 5+5);
    }

    @Test
    public void testParallel9() throws InterruptedException {
        Thread.sleep(10000);
        Assertions.assertEquals(10, 5+5);
    }

    @Test
    public void testParallel10() throws InterruptedException {
        Thread.sleep(10000);
        Assertions.assertEquals(10, 5+5);
    }
}
