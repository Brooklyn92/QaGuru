package hw4.tests;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static hw4.tests.TestData.email;

public class StudentRegistrationWitchFakerTests extends TestBase {
    Faker faker = new Faker(new Locale("ru"));
    String firstName = faker.name().firstName();
    String lastName=faker.name().lastName();
    String address=faker.address().streetAddress();
    String phone=faker.numerify("8#########");
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
                        .inputCurrentAddress(address)
                        .typeStateAndCity("NCR","Delhi")
                        .clickButtonSubmit();
       registrationPage
                .checkResultValue("Student Name", firstName + " " + lastName)
                .checkResultValue("Student Email",email)
                .checkResultValue("Gender","Female")
                .checkResultValue("Mobile",phone)
                .checkResultValue("Date of Birth","22 December,1992")
                .checkResultValue("Subjects","Chemistry")
                .checkResultValue("Hobbies","Music")
                .checkResultValue("Picture","1.png")
                .checkResultValue("Address",address)
                .checkResultValue("State and City","NCR Delhi")
                .closeTableResult();
    }

}
