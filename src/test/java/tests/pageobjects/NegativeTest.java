package tests.pageobjects;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.TestBase;

public class NegativeTest extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void invalidEmailTest() {
        registrationPage.openPage()
                .setFirstName("ilya")
                .setLastName("shchepetin")
                .setEmail("shchepetin.idornet.ru")
                .setGender("Male")
                .setUserNumber("8999999999")
                .submit()
                .verifyResults()
                .verifyResult("Student Name", "ilya shchepetin")
                .verifyResult("Student Email", "shchepetin.idornet.ru")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "8999999999");
    }
}
