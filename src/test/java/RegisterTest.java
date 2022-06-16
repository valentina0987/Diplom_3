import PageObject.RegisterPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static PageObject.RegisterPage.REGISTER_PAGE_URL;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class RegisterTest {

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
    @DisplayName("Correct registration")
    @Description("Проверка успешной регистрации с последующим переходом на страницу входа")
    public void validRegistrationTest() {
        RegisterPage registerPage = open(REGISTER_PAGE_URL, RegisterPage.class);
        registerPage.newUserRegistration(registerPage.NAME, registerPage.EMAIL, registerPage.PASSWORD);
        registerPage.waitAfterRegistration();
        boolean isDisplayed = registerPage.checkEntryButton();
        Assert.assertTrue("После успешной регистрации пользователь должен быть перенаправлен на страницу входа в систему", isDisplayed);
    }

    @Test
    @DisplayName("Incorrect registration")
    @Description("Проверка регистрации с ошибкой пароля и последующим выводом предупреждения 'Некорректный пароль'")
    public void invalidRegistrationTest() {
        RegisterPage registerPage = open(REGISTER_PAGE_URL, RegisterPage.class);
        registerPage.newUserRegistration(registerPage.NAME, registerPage.EMAIL, registerPage.INCORRECT_PASSWORD);
        registerPage.waitAfterRegistration();
        boolean expectedResult = registerPage.checkIncorrectPasswordSign();
        Assert.assertTrue("Необходим вывод предупреждения 'Некорректный пароль'", expectedResult);
    }
}