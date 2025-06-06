package tests.jenkins;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import java.util.Map;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import org.openqa.selenium.remote.DesiredCapabilities;

@Tag("Jenkins")
public class JenkinsTest {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.browser = "chrome";
        //Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Test
    public void jenkinsFillFormTest() {
        step("Open", () -> {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });
        step("Fill form", () -> {
            $("#firstName").setValue("ilya");
            $("#lastName").setValue("shchepetin");
            $("#userEmail").setValue("shchepetin.i@dornet.ru");
            $("#genterWrapper").$(byText("Male")).click();
            $("#userNumber").setValue("8999999999");


            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").selectOption("1997");
            $(".react-datepicker__month-select").selectOption("April");
            $$("div.react-datepicker__day").findBy(text("23")).click();


            $("#subjectsInput").setValue("Hindi").pressEnter();
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#uploadPicture").uploadFromClasspath("QA_GURU.jpg");
            $("#currentAddress").setValue("Oktuabriskaya");

            $("#state").click();
            $("#react-select-3-input").setValue("NCR").pressEnter();
            $("#city").click();
            $("#react-select-4-input").setValue("Delhi").pressEnter();

            $("#submit").click();
        });

        step("Show results", () -> {
            $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("ilya shchepetin"));
            $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("shchepetin.i@dornet.ru"));
            $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
            $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8999999999"));
            $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("23 April,1997"));
            $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Hindi"));
            $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
            $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("QA_GURU.jpg"));
            $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Oktuabriskaya"));
            $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
        });
    }

    @AfterEach
    void addAttachments() {
        helpers.Attach.screenshotAs("Last screenshot");
        helpers.Attach.pageSource();
        helpers.Attach.browserConsoleLogs();
        helpers.Attach.addVideo();
    }
}
