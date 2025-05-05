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
    public void test() {
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

        $$("table tr").findBy(text("Student Name")).shouldHave(text("ilya shchepetin"));
        $$("table tr").findBy(text("Student Email")).shouldHave(text("shchepetin.i@dornet.ru"));
        $$("table tr").findBy(text("Gender")).shouldHave(text("Male"));
        $$("table tr").findBy(text("Mobile")).shouldHave(text("8999999999"));
        $$("table tr").findBy(text("Date of Birth")).shouldHave(text("23 April,1997"));
        $$("table tr").findBy(text("Subjects")).shouldHave(text("Hindi"));
        $$("table tr").findBy(text("Hobbies")).shouldHave(text("Sports"));
        $$("table tr").findBy(text("Picture")).shouldHave(text("QA_GURU.jpg"));
        $$("table tr").findBy(text("Address")).shouldHave(text("Oktuabriskaya"));
        $$("table tr").findBy(text("State and City")).shouldHave(text("NCR Delhi"));

    }
}