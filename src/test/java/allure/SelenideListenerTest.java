package allure;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideListenerTest extends TestBase {

    @Test
    @Feature("Check issue with pure Selenide")
    @Story("Verify issue name via steps annotation with pure Selenide")
    @DisplayName("Verify issue name with Selenide")
    @Severity(SeverityLevel.NORMAL)
    @Owner("domanovdi")
    void issueSearch(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(url);
        searchInput.click();
        query.setValue(name).pressEnter();
        $(linkText(repo)).click();
        issueTab.click();
        $(withText(issue)).should(exist);
    }
}
