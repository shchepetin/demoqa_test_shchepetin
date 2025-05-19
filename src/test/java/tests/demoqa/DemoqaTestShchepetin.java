package tests.demoqa;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class DemoqaTestShchepetin {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    public void fillFormTest() {
        open("/automation-practice-form");

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

    }
}