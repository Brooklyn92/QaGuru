package hw4.tests;
import org.junit.jupiter.api.Test;

import static hw4.tests.TestData.*;

public class StudentRegistrationWitchTestDataTests extends TestBase {
    @Test
    public void testing(){
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName)
                        .typeLastName(lastName)
                        .typeEmail(email)
                        .setGender("Female")
                        .typeMobile(phone)
                        .selectDateBirth("December","1992","22")
                        .inputSubjects("e", "Chemistry")
                        .setHobbies("Music")
                        .uploadFile("img/1.png")
                        .inputCurrentAddress(addres)
                        .typeStateAndCity("NCR","Delhi")
                        .clickButtonSubmit();
       registrationPage
                .checkResultValue("Student Name",firstName + " " + lastName)
                .checkResultValue("Student Email",email)
                .checkResultValue("Gender","Female")
                .checkResultValue("Mobile", phone)
                .checkResultValue("Date of Birth","22 December,1992")
                .checkResultValue("Subjects","Chemistry")
                .checkResultValue("Hobbies","Music")
                .checkResultValue("Picture","1.png")
                .checkResultValue("Address",addres)
                .checkResultValue("State and City","NCR Delhi")
                .closeTableResult();
    }

}
