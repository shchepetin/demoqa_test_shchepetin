package tests.faker;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import tests.TestBase;
import static utils.RandomUtils.*;

public class FakerTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fullRegistrationTest() {
        String firstName = randomFirstName();
        String lastName = randomLastName();
        String email = randomEmail();
        String gender = randomGender();
        String phone = randomPhone();
        String birthDay = randomDay();
        String birthMonth = randomMonth();
        String birthYear = randomYear();
        String subject = randomSubject();
        String hobby = randomHobby();
        String address = randomAddress();
        String state = randomState();
        String city = randomCity(state);

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phone)
                .setDateOfBirth(birthDay, birthMonth, birthYear)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture("QA_GURU.jpg")
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit()
                .verifyResults()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phone)
                .verifyResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", "QA_GURU.jpg")
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);
    }

    @Test
    void minimalRegistrationTest() {
        String firstName = randomFirstName();
        String lastName = randomLastName();
        String email = randomEmail();
        String gender = randomGender();
        String phone = randomPhone();

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phone)
                .submit()
                .verifyResults()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phone);
    }
}