package pageObject;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;

public class MainPage {

    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH, using = "//nav/a[@class='AppHeader_header__link__3D_hX']")
    private SelenideElement personalAccountButton;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Войти в аккаунт')]")
    private SelenideElement makeOrderButton;

    @FindBy(how = How.XPATH, using = ".//p[contains(text(), 'Конструктор')]/..")
    private SelenideElement burgerConstructor;

    @FindBy(how = How.XPATH, using = ".//h1[contains(text(), 'Соберите бургер')]")
    private SelenideElement assembleTheBurger;

    @FindBy(how = How.XPATH, using = "//div//span[text()='Булки']")
    private SelenideElement allBuns;

    @FindBy(how = How.XPATH, using = "//div//span[text()='Соусы']")
    private SelenideElement allSauces;

    @FindBy(how = How.XPATH, using = "//div//span[text()='Начинки']")
    private SelenideElement allFillings;

    @FindBy(how = How.XPATH, using = "//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logo;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Оформить заказ')]")
    private SelenideElement placeAnOrder;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'tab_tab_type_current__2BEPc')]//span[contains(text(),'Булки')]")
    private SelenideElement activeBunSection;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'tab_tab_type_current__2BEPc')]//span[contains(text(),'Соусы')]")
    private SelenideElement activeSaucesSection;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'tab_tab_type_current__2BEPc')]//span[contains(text(),'Начинки')]")
    private SelenideElement activeFillingsSection;

    @Step("Клик на кнопку 'Личный кабинет'")
    public void loginThroughPersonalAccount() {
        personalAccountButton.shouldBe(enabled).click();
    }

    @Step("Клик на кнопку 'Войти в аккаунт'")
    public void loginThroughLoginButton() {
        makeOrderButton.shouldBe(enabled).click();
    }

    @Step("Клик на на кнопку 'Конструктор'")
    public void clickToConstructor() {
        burgerConstructor.shouldBe(enabled).click();
    }

    @Step("Клик на логотип 'Stellar Burger'")
    public void clickLogo() { logo.shouldBe(enabled).click();}

    @Step("Переход к разделу 'Булки'")
    public void checkBuns() {
        allBuns.click();
    }

    @Step("Переход к разделу 'Соусы'")
    public void checkSauces() {
        allSauces.click();
    }

    @Step("Переход к разделу 'Начинки'")
    public void checkFillings() {
        allFillings.click();
    }

    @Step("Проверяем, что переход к разделу Булки осуществлен")
    public boolean isBunDisplayed() {
        return activeBunSection.exists();
    }

    @Step("Проверяем, что переход к разделу Соусы осуществлен")
    public boolean isSaucesDisplayed() {
        return activeSaucesSection.exists();
    }

    @Step("Проверяем, что переход к разделу Начинки осуществлен")
    public boolean isFillingsDisplayed() {
        return activeFillingsSection.exists();
    }

    @Step("Проверяем, что кнопка 'Оформить заказ'отображается")
    public boolean checkPlaceAnOrder() {
        return placeAnOrder.isDisplayed();
    }

    @Step("Проверяем, что заголовок 'Собрать бургер'отображается")
    public boolean checkAssembleTheBurger() {
        return assembleTheBurger.isDisplayed();
    }

    @Step("Проверяем, что логотип 'Stellar Burger' отображается")
    public boolean checkLogo() {
        return logo.isDisplayed();
    }

}
