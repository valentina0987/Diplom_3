import PageObject.AccountPage;
import PageObject.LoginPage;
import PageObject.MainPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;

public class LogOutOfAccountTest {
    AccountPage accountPage;
    LoginPage loginPage;
    MainPage mainPage;

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
    @DisplayName("Checking the correct exit by clicking the 'Exit' button in your personal account")
    @Description("Проверка корректного выхода по кнопке 'Выйти' в личном кабинете")
    public void checkExitOutOfYourAccount() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.loginThroughLoginButton();
        LoginPage login = page(LoginPage.class);
        login.sendEmailAndPassword(login.EMAIL, login.PASSWORD);
        login.waitingForLogin();
        mainPage.loginThroughPersonalAccount();
        AccountPage accountPage = page(AccountPage.class);
        accountPage.logOutOfYourAccount();
        LoginPage loginPage = page(LoginPage.class);
        Assert.assertTrue("Выход не выполнен. Страница входа пользователя недоступна", loginPage.checkVisibleTitleLogin());
    }
}