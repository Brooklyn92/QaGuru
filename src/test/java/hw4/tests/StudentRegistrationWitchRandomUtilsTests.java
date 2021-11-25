package hw4.tests;
import org.junit.jupiter.api.Test;

import static hw4.tests.TestData.email;
import static hw4.utils.RandomUtils.getRandomString;

public class StudentRegistrationWitchRandomUtilsTests extends TestBase {
    //String firstName= getRandomString(10);
    @Test
    public void testing(){
        registrationPage.openPage();
        registrationPage.typeFirstName("New York")
                        .typeLastName("Brooklyn")
                        .typeEmail(email)
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
                .checkResultValue("Student Email",email)
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
