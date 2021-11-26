package lesson5;

import io.qameta.allure.Allure;
import lesson5.steps.WebSteps;
import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;

public class ParametersTest extends TestBase {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private WebSteps steps=new WebSteps();

    @DisplayName("Проверка города")
    //@ParameterizedTest(name = "{displayName} {0}")
    //@ValueSource(strings = {"Санкт-Петербург","Москва"} )
    public void testLambda(String city){
        Allure.parameter("Город", city);
    }

}
