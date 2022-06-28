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
import static pageObject.MainPage.MAIN_PAGE_URL;

public class ConstructorTest {

    @Before
    public void setUp() {
        closeWebDriver();
        browser = browser;
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
        MainPage mainPage = open(MAIN_PAGE_URL, MainPage.class);
        mainPage.clickToConstructor();
        mainPage.checkBuns();
        Assert.assertTrue("Переход к разделу 'Булки' недоступен", mainPage.isDisplayedFluorescentBun());
        mainPage.getSauces();
        Assert.assertTrue("Переход к разделу 'Соусы' недоступен", mainPage.checkSpicyX());
        mainPage.checkFillings();
        Assert.assertTrue("Переход к разделу 'Начинки' недоступен", mainPage.checkProtostomiaMeat());
    }
}
