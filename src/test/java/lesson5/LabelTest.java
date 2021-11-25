package lesson5;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelTest{

    @Test
    @Link(name = "GitHub", url = "https://github.com")
    @Owner("Yurchenko Aleksandr")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Авторизация")
    @Story("Авторизация через Email")
    @DisplayName("Мой самый любимый тест")
    public void testAnnotated() {

    }

    @Test
    public void testLambda() {
        Allure.getLifecycle().updateTestCase(testCase -> {
            testCase.setName("Мой любимый тест");
        });
        Allure.label("owner", "Yurchenko Aleksandr");
        Allure.feature("Авторизация");
        Allure.story("Авторизация через Email");
        Allure.label("severity","BLOCKER");
        Allure.link("GitHub", "https://github.com");

    }

}
