package com.yandex;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;

public class LogOutOfAccountTest {
    AccountPage accountPage;
    MainPage mainPage;

    // Проверь выход по кнопке «Выйти» в личном кабинете

    @Test
    @DisplayName("Checking the exit by clicking the 'Exit' button in your personal account")
    @Description("Проверяем выход по кнопке «Выйти» в личном кабинете")
    public void logOutOfYourAccountTest() {
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.checkAuthForm();
        loginPage.sendEmailAndPassword("valentina.zamotaeva@yandex.ru", "010101");
        loginPage.clickTheLoginButton();
        mainPage.loginToPersonalAccount();
        accountPage.logOutOfYourAccount();
        loginPage.checkAuthForm();
    }
    // тест падает на этапе заполнения емейла (пароль вроде проходит), локаторы для поля пароля уже меняла много раз
}
