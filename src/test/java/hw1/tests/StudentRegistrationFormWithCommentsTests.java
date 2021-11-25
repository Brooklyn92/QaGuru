package hw1.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class StudentRegistrationFormWithCommentsTests {

    final SelenideElement firstName = $("[id=firstName]");
    final SelenideElement lastName = $("[id=lastName]");
    final SelenideElement email = $(byXpath("//input[@placeholder='name@example.com']"));
    final SelenideElement gender = $(byText("Male"));
    final SelenideElement mobile = $(byXpath("//input[@placeholder='Mobile Number']"));
    final SelenideElement dateOfBirth = $(byXpath("//input[@id='dateOfBirthInput']"));
    final SelenideElement selectMonthInput = $(byXpath("//select[@class='react-datepicker__month-select']"));
    final SelenideElement selectValueMonth = $(byXpath("//option[@value='11']"));
    final SelenideElement selectYearInput = $(byXpath("//select[@class='react-datepicker__year-select']"));
    final SelenideElement selectValueYear = $(byXpath("//option[@value='1992']"));
    final SelenideElement selectValueDay = $x("//div[@class='react-datepicker__day react-datepicker__day--022']");
    final SelenideElement subjectsSetValue = $(byXpath("//input[@id='subjectsInput']"));
    final SelenideElement subjectCickValue = $(byText("English"));
    final SelenideElement hobbies = $(byXpath("//label[@for='hobbies-checkbox-1']"));
    final SelenideElement picture = $(By.id("uploadPicture"));
    final SelenideElement currentAddress = $(byXpath(".//textarea"));
    final SelenideElement clickState = $(byText("Select State"));
    final SelenideElement setState = $(byText("NCR"));
    final SelenideElement clickCity = $(byText("Select City"));
    final SelenideElement setCity = $(byText("Delhi"));
    final SelenideElement clickSubmit = $x("//button[@id='submit']");



    @BeforeAll
    static void setting(){
        Configuration.startMaximized=true;
    }


    @Test
    public void testing(){
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        firstName.setValue("New York");
        lastName.setValue("Brooklyn");
        email.setValue("Brooklyn@yandex.ru");
        gender.click();
        mobile.setValue("8909909999");
        dateOfBirth.click();
        selectMonthInput.click();
        selectValueMonth.click();
        selectYearInput.click();
        selectValueYear.click();
        selectValueDay.click();
        subjectsSetValue.setValue("e");
        subjectCickValue.click();
        hobbies.click();
        picture.uploadFile(new File("F:\\QAGuruStudy\\QAGuru_Study\\QaGuru\\src\\test\\resources\\img\\1.png"));
        currentAddress.setValue("My first home work");
        clickState.click();
        setState.click();
        clickCity.click();
        setCity.click();
        clickSubmit.click();
    }

    @Test
    public void checkTableAndClose(){
        $x("//div[@class='table-responsive']").shouldHave(text("New York Brooklyn"), text("Brooklyn@yandex.ru"),
                text("Male"),text("8909909999"),text("22 December,1992"),text("English"),text("Sports"),text("1.png"),
                text("My first home work"),text("NCR Delhi"));

        $x("//button[@id='closeLargeModal']")
                .click();
    }
}
