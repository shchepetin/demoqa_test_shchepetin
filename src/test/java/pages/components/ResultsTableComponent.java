package pages.components;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTableComponent {
    private final SelenideElement
            modalContent = $("#example-modal-sizes-title-lg"),
            contentForm = $(".table-responsive");

    public ResultsTableComponent checkModalAppears() {
        modalContent.should(appear)
                .shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public ResultsTableComponent checkResult(String key, String value) {
        contentForm.$(byText(key))
                .parent()
                .shouldHave(text(value));
        return this;
    }
}