package allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest extends TestBase {

    @Test
    @Feature("Check issue with pure Selenide")
    @Story("Verify issue name via lambda steps annotation")
    @DisplayName("Verify issue name with lambda steps")
    @Severity(SeverityLevel.NORMAL)
    @Owner("domanovdi")
    void lambdaStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open(url);
        });
        step("Поиск репозитория" + repo, () -> {
            searchInput.click();
            query.setValue(name).pressEnter();
        });
        step("Кликаем по ссылке репозитория", () -> {
            $(linkText(repo)).click();
        });
        step("Кликаем по вкладке Issues", () -> {
            issueTab.click();
        });
        step("Проверяем наличие Issue", () -> {
            $(withText(issue)).should(exist);
        });
    }

    @Test
    @Feature("Check issue with pure Selenide")
    @Story("Verify issue name via steps annotation")
    @DisplayName("Verify issue name with steps")
    @Severity(SeverityLevel.NORMAL)
    @Owner("domanovdi")
    void stepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        AnnotationSteps steps = new AnnotationSteps();

        steps.openMainPage();
        steps.repositorySearch();
        steps.repositoryClick();
        steps.issuesClick();
        steps.issuesCheck();
    }
}
