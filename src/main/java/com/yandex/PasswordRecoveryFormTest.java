package com.yandex;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class PasswordRecoveryFormTest {

    //URL формы восстановления пароля
    public static final String FORGOT_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    // поле email
    @FindBy(xpath = "//input[@name='name']")
    private SelenideElement emailField;

    // кнопка "Восстановить"
    @FindBy(xpath = "//button[contains(text(),'Восстановить')]")
    private SelenideElement restoreButton;

    @Step("Fill the field 'Email'")
    public void fillEmailField(String email) {
        emailField.clear();
        emailField.sendKeys();
    }

    @Step("Click the restore button")
    public void clickTheEntryButton() {
        restoreButton.scrollTo().click();
    }
}
