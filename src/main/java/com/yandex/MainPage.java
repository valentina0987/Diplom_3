package com.yandex;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static java.time.Duration.ofSeconds;

public class MainPage {

    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    // кнопка "Личный кабинет"
    @FindBy(xpath = "//nav/a[@class='AppHeader_header__link__3D_hX']")
    private SelenideElement personalAccountButton;

    // кнопка "Войти в аккаунт"
    @FindBy(xpath = "//button[contains(text(),'Войти в аккаунт')]")
    private SelenideElement makeOrderButton;

    // Конструктор бургеров
    @FindBy(xpath = ".//p[contains(text(), 'Конструктор')]/..")
    private SelenideElement burgerConstructor;

    // Булки
    @FindBy(xpath = ".//h2[contains(text(), 'Булки')]")
    private SelenideElement allBuns;

    // Флюоресцентная булка
    @FindBy(xpath = "//p[contains(text(),'Флюоресцентная булка R2-D3')]")
    private SelenideElement fluorescentBun;

    // Соусы
    @FindBy(xpath = ".//h2[contains(text(), 'Соусы')]")
    private SelenideElement allSauces;

    // Соус Spicy-X
    @FindBy(xpath = "//img[@alt='Соус Spicy-X']")
    private SelenideElement spicyX;

    // Начинки
    @FindBy(xpath = ".//h2[contains(text(), 'Начинки')]")
    private SelenideElement allFillings;

    // Мясо бессмертных моллюсков Protostomia
    @FindBy(xpath = "//img[@alt='Мясо бессмертных моллюсков Protostomia']")
    private SelenideElement protostomiaMeat;

    // Логотип
    @FindBy(xpath = "//div[@class='AppHeader_header__logo__2D0X2']")
    private static SelenideElement logo;

    //public static void waitForLoadMainPage() {
        //logo.shouldBe(visible, ofSeconds(20));
    //}


    @Step ("Проверяем видна ли кнопка 'Личный кабинет'")
    public boolean checkVisiblePersonalAccountButton() {
        return personalAccountButton.hover().is(Condition.visible);
    }

    //Клик на кнопку "Личный кабинет"
    @Step("Go to personal account")
    public void loginToPersonalAccount() {
        personalAccountButton.shouldBe(enabled).click();
    }

    //Клик на кнопку "Конструктор"
    @Step("Go to Constructor")
    public void clickToConstructor() {
        burgerConstructor.shouldBe(enabled).click();
    }

    // клик по булкам
    public void checkBuns() {
        allBuns.click();
    }
    // клик по соусам
    public void checkSauces() {
        allSauces.click();
    }
    // клик по начинкам
    public void checkFillings() {
        allFillings.click();
    }

    // проверяем что видна булка
    @Step("FluorescentBun is visible")
    public void checkFluorescentBun() {
        fluorescentBun.isDisplayed();
    }

    // проверяем что виден соус
    @Step("Spicy-X is visible")
    public void checkSpicyX() {
        spicyX.isDisplayed();
    }

    // проверяем что видна начинка
        @Step("ProtostomiaMeat is visible")
        public void checkProtostomiaMeat() {
            protostomiaMeat.isDisplayed();
        }
}
