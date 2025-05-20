package tests.pageobjects;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.TestBase;

public class MinimalSuccessfulRegistration extends TestBase {
    @Test
    public void minimalSuccessfulRegistrationTest() {
        RegistrationPage RegistrationPage = new RegistrationPage()
                .openPage()
                .setFirstName("ilya")
                .setLastName("shchepetin")
                .setEmail("shchepetin.i@dornet.ru")
                .setGender("Male")
                .setUserNumber("8999999999")
                .submit()
                .verifyResults()
                .verifyResult("Student Name", "ilya shchepetin")
                .verifyResult("Student Email", "shchepetin.i@dornet.ru")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "8999999999");
    }
}