package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PasswordRecoveryForm {

    public static final String PASSWORD_RECOVERY_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement entryButtonInRecoveryForm;


    @Step("Клик на кнопку 'Войти' в форме восстановления пароля")
    public void clickEntryButtonInRecoveryForm() {
        entryButtonInRecoveryForm.click();
    }

}
