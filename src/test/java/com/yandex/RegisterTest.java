package com.yandex;

import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class RegisterTest {

    // Проверь успешную регистрацию

    @Test
    public void validRegistrationTest() {

        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        //mainPage.waitForLoadMainPage();
        mainPage.checkVisiblePersonalAccountButton();
        mainPage.loginToPersonalAccount();
        LoginPage loginPage = new LoginPage();
        //loginPage.waitForLoadLoginPage();
        loginPage.checkVisibleStartRegistration();
        loginPage.clickRegistrationButton();
        RegisterPage registerPage = new RegisterPage();
        registerPage.passRegistration("Vala", "valentin.zamotaeva@yandex.ru", "010102v");
    }

    // Проверь регистрацию с ошибкой пароля
    @Test
    public void invalidRegistrationTest() {

    }
}
