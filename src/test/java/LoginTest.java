import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.PasswordRecoveryForm;
import PageObject.RegisterPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static PageObject.MainPage.MAIN_PAGE_URL;
import static PageObject.PasswordRecoveryForm.PASSWORD_RECOVERY_URL;
import static PageObject.RegisterPage.REGISTER_PAGE_URL;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class LoginTest {
    MainPage mainPage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @Before
    public void setUp() {
        closeWebDriver();
        Configuration.browser = browser;
    }

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    // метод login.waitingForLogin() заменить на какое-то другое ожидание. Просто убрать нельзя - тест падает!
    @Test
    @DisplayName("Checking the login using the 'Log in to account' button on the main page")
    @Description("Проверка входа по кнопке «Войти в аккаунт» на главной странице")
    public void checkLoginFromMainPageThroughLoginButton() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.loginThroughLoginButton();
        LoginPage login = page(LoginPage.class);
        login.sendEmailAndPassword(login.EMAIL, login.PASSWORD);
        login.waitingForLogin();
        boolean expectedResult = mainPage.checkPlaceAnOrder();
        Assert.assertTrue("Авторизация не выполнена. Кнопка 'Оформить заказ' недоступна", expectedResult);
    }

    @Test
    @DisplayName("Checking the login using the 'Personal account' button on the main page")
    @Description("Проверка входа через кнопку «Личный кабинет»")
    public void checkLoginFromMainPageThroughPersonalAccount() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.loginThroughPersonalAccount();
        LoginPage login = page(LoginPage.class);
        login.sendEmailAndPassword(login.EMAIL, login.PASSWORD);
        login.waitingForLogin();
        boolean expectedResult = mainPage.checkPlaceAnOrder();
        Assert.assertTrue("Авторизация не выполнена. Кнопка 'Оформить заказ' недоступна", expectedResult);
    }

    @Test
    @DisplayName("Checking the login through the button in the registration form")
    @Description("Проверка входа через кнопку в форме регистрации")
    public void checkLoginThroughButtonInRegistrationForm() {
        RegisterPage registerPage = open(REGISTER_PAGE_URL, RegisterPage.class);
        registerPage.clickEntryButton();
        LoginPage login = page(LoginPage.class);
        login.sendEmailAndPassword(login.EMAIL, login.PASSWORD);
        login.waitingForLogin();
        assertEquals("Авторизация не выполнена. Главная страница недоступна",
                url(), MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("Checking the login through the button in the password recovery form")
    @Description("Проверка входа через кнопку в форме восстановления пароля")
    public void checkLoginThroughButtonInPasswordRecoveryForm() {
        PasswordRecoveryForm passwordRecoveryForm = open(PASSWORD_RECOVERY_URL, PasswordRecoveryForm.class);
        passwordRecoveryForm.clickEntryButtonInRecoveryForm();
        LoginPage login = page(LoginPage.class);
        login.sendEmailAndPassword(login.EMAIL, login.PASSWORD);
        login.waitingForLogin();
        assertEquals("Авторизация не выполнена. Главная страница недоступна",
                url(), MAIN_PAGE_URL);
    }
}
