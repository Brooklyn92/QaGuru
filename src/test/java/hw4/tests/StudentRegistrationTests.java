package hw4.tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StudentRegistrationTests extends TestBase {

    @BeforeAll
    public static void setting(){
        Configuration.startMaximized=true;
        Configuration.holdBrowserOpen=true;
    }
    @Test
    public void testing(){
        registrationPage.openPage();
        registrationPage.typeFirstName("New York")
                        .typeLastName("Brooklyn")
                        .typeEmail("Brooklyn@yandex.ru")
                        .setGender("Female")
                        .typeMobile("8909909999")
                        .selectDateBirth("December","1992","22")
                        .inputSubjects("e", "Chemistry")
                        .setHobbies("Music")
                        .uploadFile("img/1.png")
                        .inputCurrentAddress("Ulyanovsk, Russia")
                        .typeStateAndCity("NCR","Delhi")
                        .clickButtonSubmit();
       registrationPage
                .checkResultValue("Student Name","New York Brooklyn")
                .checkResultValue("Student Email","Brooklyn@yandex.ru")
                .checkResultValue("Gender","Female")
                .checkResultValue("Mobile","8909909999")
                .checkResultValue("Date of Birth","22 December,1992")
                .checkResultValue("Subjects","Chemistry")
                .checkResultValue("Hobbies","Music")
                .checkResultValue("Picture","1.png")
                .checkResultValue("Address","Ulyanovsk, Russia")
                .checkResultValue("State and City","NCR Delhi")
                .closeTableResult();
    }

}
