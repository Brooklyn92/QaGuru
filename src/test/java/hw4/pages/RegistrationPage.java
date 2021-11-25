package hw4.pages;

import com.codeborne.selenide.SelenideElement;
import hw4.pages.components.CalendarComponent;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    //locators
     private final String FORM_TITLE = "Student Registration Form";

     private final SelenideElement
             formTitle= $(".practice-form-wrapper"),
             firstNameInput = $("[id=firstName]"),
             lastName = $("[id=lastName]"),
             email = $(byXpath("//input[@placeholder='name@example.com']")),
             genderSet= $x("//div[@id='genterWrapper']"),
             mobile = $(byXpath("//input[@placeholder='Mobile Number']")),
             subjects= $(byXpath("//input[@id='subjectsInput']")),
             hobbies = $("#hobbiesWrapper"),
             picture=$(By.id("uploadPicture")),
             currentAddressInput = $(byXpath(".//textarea")),
             clickSubmit = $x("//button[@id='submit']"),
             resultTable=$x("//div[@class='table-responsive']"),
             closeTable = $x("//button[@id='closeLargeModal']");



    //actions
    //========================================CHAIN PAGE OBJECT==============================================
    public void openPage(){
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public CalendarComponent calendar=new CalendarComponent();

    public RegistrationPage typeFirstName(String inputName){
        firstNameInput.setValue(inputName);
        return this;
    }

    public RegistrationPage typeLastName(String inputLastName){
        lastName.setValue(inputLastName);
        return this;
    }

    public RegistrationPage typeEmail(String inputEmail){
        email.setValue(inputEmail);
        return this;
    }

    public RegistrationPage setGender(String selectGender){
        genderSet.find(byText(selectGender)).click();
        return this;
    }

    public RegistrationPage typeMobile(String inputMobile){
        mobile.setValue(inputMobile);
        return this;
    }

    public RegistrationPage selectDateBirth(String mont,String year, String day){
        $(byXpath("//input[@id='dateOfBirthInput']")).click();
        $(byXpath("//select[@class='react-datepicker__month-select']")).click();
        $$(byXpath("//select[@class='react-datepicker__month-select']/child::option")).find(text(mont)).click();
        $$(byXpath("//select[@class='react-datepicker__year-select']/child::option")).find(text(year)).click();
        //$$x("//div[@class='react-datepicker__week']/div").find(text(day)).click();
        $(".react-datepicker__day--0" +day+ ":not(.react-datepicker__day--outside-month)").click();
        return this;
    }

    public RegistrationPage inputSubjects(String key, String value){
        subjects.sendKeys(key);
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage setHobbies(String value){
     hobbies.find(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadFile(String value){
        picture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage inputCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }
    public RegistrationPage typeStateAndCity(String selectState, String SelectCity){
        $("#state").click();
        $(byText(selectState)).click();
        $("#city").click();
        $(byText(SelectCity)).click();
        return this;
    }
    public RegistrationPage clickButtonSubmit(){
        clickSubmit.click();
        return this;
    }

    public RegistrationPage  checkResultValue(String key, String value){
        resultTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public RegistrationPage closeTableResult(){
        closeTable.click();
        return this;
    }

}
