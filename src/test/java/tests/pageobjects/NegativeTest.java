package tests.pageobjects;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.TestBase;

public class NegativeTest extends TestBase{
    @Test
    public void invalidEmailTest() {
        RegistrationPage RegistrationPage = new RegistrationPage()
                .openPage()
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
