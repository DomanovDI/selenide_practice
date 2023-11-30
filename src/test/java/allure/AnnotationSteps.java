package allure;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;


public class AnnotationSteps extends TestBase {

    @Step("Открываем главную страницу")
    void openMainPage() {
        open(url);
    }

    @Step("Поиск репозитория {repo}")
    void repositorySearch() {
        searchInput.click();
        query.setValue(name).pressEnter();
    }

    @Step("Кликаем по ссылке репозитория")
    void repositoryClick() {
        $(linkText(repo)).click();
    }

    @Step("Кликаем по вкладке Issues")
    void issuesClick() {
        issueTab.click();
    }

    @Step("Проверяем наличие Issue {issue}")
    void issuesCheck() {
        issueTab.click();
    }
}
