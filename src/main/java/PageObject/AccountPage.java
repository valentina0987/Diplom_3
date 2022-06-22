package PageObject;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;

//Протестируй функциональность в Google Chrome и Яндекс.Браузере. Подключи Allure-отчёт.!!!!!!!!!

public class AccountPage {
    public static final String PROFILE_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Выход')]")
    private SelenideElement outOfAccountButton;

    @Step("Клик на кнопку выхода")
    public void logOutOfYourAccount() {
        outOfAccountButton.shouldBe(enabled).click();
    }
}
