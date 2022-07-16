import com.codeborne.selenide.Configuration;
import pageObject.MainPage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {

    @Before
    public void setUp() {
        closeWebDriver();
        browser = browser;
        Configuration.timeout = 10000;
    }

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("Transitions to the sections of the constructor")
    @Description("Проверяем, что работают переходы к разделам: «Булки», «Соусы», «Начинки»")
    public void checkTheTransitionToSectionsTest() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.clickToConstructor();
        mainPage.checkFillings();
        Assert.assertTrue("Переход к разделу 'Начинки' неосуществелен", mainPage.isFillingsDisplayed());
        mainPage.checkSauces();
        Assert.assertTrue("Переход к разделу 'Соусы' неосуществелен", mainPage.isSaucesDisplayed());
        mainPage.checkBuns();
        Assert.assertTrue("Переход к разделу 'Булки' неосуществелен", mainPage.isBunDisplayed());
    }
}
