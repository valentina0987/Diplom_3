package com.yandex;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {

    public static final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    // кнопка "Регистрация"
    @FindBy(xpath = "//a[contains(text(),'Зарегистрироваться')]")
    private SelenideElement startRegistration;

    // поле "Имя" при регистрации
    @FindBy(xpath = ".//label[text() = 'Имя']/../input")
    private SelenideElement nameField;

    // поле "Почта" при регистрации
    @FindBy(xpath = ".//label[text() = 'Email']/../input")
    private SelenideElement emailField;

    // поле "Пароль" при регистрации
    @FindBy(xpath = ".//label[text() = 'Пароль']/../input")
    private SelenideElement passwordField;

    // кнопка "Зарегистрироваться" (после заполнения всех полей)
    @FindBy(xpath = "//button[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registerButton;


    @Step ("Проверяем виден ли заголовок 'Регистрация'")
    public boolean checkVisibleRegistration() {
        return startRegistration.hover().is(Condition.visible);
    }

    @Step("Pass the Registration")
    public void passRegistration(String name, String email, String password) {
        nameField.clear();
        nameField.sendKeys();
        emailField.clear();
        emailField.sendKeys();
        passwordField.clear();
        passwordField.sendKeys();
        registerButton.click();
    }

    public String isRegisterButtonClickable() {
        return registerButton.getAttribute("disabled");
    }

    //public String getLoginСonfirmText() {
        //return loginСonfirmText.getText();
    //}
}

