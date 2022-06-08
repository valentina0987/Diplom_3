package com.yandex;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static java.time.Duration.ofSeconds;

public class LoginPage {

    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    // Логотип
    @FindBy(xpath = "//div[@class='AppHeader_header__logo__2D0X2']")
    private static SelenideElement logo;

    // поле "Почта пользователя"
    //@FindBy(xpath = "//div[@class='input pr-6 pl-6 input_type_text input_size_default']")
    @FindBy(xpath = ".//label[text() = 'Email']/../input")
    private SelenideElement userEmailField;

    // поле "Пароль пользователя"
    @FindBy(xpath = "//div[@class='input pr-6 pl-6 input_type_password input_size_default']")
    private SelenideElement userPasswordField;

    // кнопка "Войти"
    @FindBy(xpath = "//button[contains(text(),'Войти')]")
    private SelenideElement userLoginButton;

    // кнопка "Зарегистрироваться"
    @FindBy(xpath = "//a[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registrationButton;

    // кнопка "Восстановить пароль"
    @FindBy(xpath = "//a[contains(text(),'Восстановить пароль')]")
    private SelenideElement recoverPasswordButton;

    // форма аутентификации
    @FindBy(xpath = "//form[@class='Auth_form__3qKeq mb-20']")
    private SelenideElement authForm;

    public static void waitForLoadLoginPage() {
        logo.shouldBe(visible, ofSeconds(8));
    }

    @Step ("Проверяем видна ли 'Регистрация'")
    public boolean checkVisibleStartRegistration() {
        return registrationButton.hover().is(Condition.visible);
    }

    @Step("Кликаем по регистрации")
    public void clickRegistrationButton() {
        registrationButton.shouldBe(enabled).click();
    }

    // форма видна
    @Step("Go to auth form")
    public void checkAuthForm() {
        authForm.shouldBe(enabled).click();
    }


    @Step("Entering the user's email and password")
    public void sendEmailAndPassword(String email, String password) {
        userEmailField.clear();
        userEmailField.sendKeys();
        userPasswordField.clear();
        userPasswordField.sendKeys();
    }

    @Step("Сlick the log in button")
    public void clickTheLoginButton() {
        userLoginButton.click();
    }
}