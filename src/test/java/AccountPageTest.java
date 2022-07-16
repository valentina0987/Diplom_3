import pageObject.AccountPage;
import pageObject.LoginPage;
import pageObject.MainPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static pageObject.LoginPage.LOGIN_PAGE_URL;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;
import static pageObject.MainPage.MAIN_PAGE_URL;

public class AccountPageTest {

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

    @Test
    @DisplayName("Transfer to your personal account")
    @Description("Переход по клику на 'Личный кабинет'")
    public void switchToPersonalAccount() {
        MainPage mainPage = open(MAIN_PAGE_URL, MainPage.class);
        mainPage.loginThroughLoginButton();
        LoginPage loginPage = page(LoginPage.class);
        assertEquals("Клик по кнопке 'Личный кабинет' не осуществлен",
                url(), LOGIN_PAGE_URL);
    }

    @Test
    @DisplayName("Switching from personal account to the constructor")
    @Description("Переход из личного кабинета по клику на 'Конструктор'")
    public void switchToConstructorFromPersonalAccount() {
        MainPage mainPage = open(MAIN_PAGE_URL, MainPage.class);
        mainPage.loginThroughLoginButton();
        LoginPage login = page(LoginPage.class);
        login.sendEmailAndPassword(login.EMAIL, login.PASSWORD);
        login.waitingForLogin();
        mainPage.loginThroughPersonalAccount();
        mainPage.clickToConstructor();
        Assert.assertTrue("Переход из личного кабинета в'Конструктор' не осуществлен", mainPage.checkAssembleTheBurger());
    }

    @Test
    @DisplayName("Switching from personal account to the logo Stellar Burger")
    @Description("Переход из личного кабинета по клику на логотип 'Stellar Burger'")
    public void switchToLogoStellarBurgerFromPersonalAccount() {
        MainPage mainPage = open(MAIN_PAGE_URL, MainPage.class);
        mainPage.loginThroughLoginButton();
        LoginPage login = page(LoginPage.class);
        login.sendEmailAndPassword(login.EMAIL, login.PASSWORD);
        login.waitingForLogin();
        mainPage.loginThroughPersonalAccount();
        mainPage.clickLogo();
        Assert.assertTrue("Клик из личного кабинета по логотипу 'Stellar Burger' не осуществлен", mainPage.checkLogo());
    }

}