package tests.demoqa;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.TestBase;

public class DemoqaTestShchepetinPageObjects extends TestBase {
    @Test
    public void fillFormTestPageObjects() {
        RegistrationPage RegistrationPage = new RegistrationPage()
                .openPage()
                .setFirstName("ilya")
                .setLastName("shchepetin")
                .setEmail("shchepetin.i@dornet.ru")
                .setGender("Male")
                .setUserNumber("8999999999")
                .setDateOfBirth("23", "April", "1997")
                .setSubject("Hindi")
                .setHobby("Sports")
                .uploadPicture("QA_GURU.jpg")
                .setAddress("Oktuabriskaya")
                .setState("NCR")
                .setCity("Delhi")
                .submit()
                .verifyResults()
                .verifyResult("Student Name", "ilya shchepetin")
                .verifyResult("Student Email", "shchepetin.i@dornet.ru")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "8999999999")
                .verifyResult("Date of Birth", "23 April,1997")
                .verifyResult("Subjects", "Hindi")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "QA_GURU.jpg")
                .verifyResult("Address", "Oktuabriskaya")
                .verifyResult("State and City", "NCR Delhi");
    }
}