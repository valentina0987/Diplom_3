package com.yandex;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {
    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    // кнопка "Выход"
    @FindBy(xpath = "//button[contains(text(),'Выход')]")
    private SelenideElement outOfAccountButton;

    // информация о владельце аккаунта
    @FindBy(xpath = "//div[@class='Account_account__vgk_w']")
    private SelenideElement nawAccount;

    // выход из личного кабинета
    public void logOutOfYourAccount() {
        outOfAccountButton.click();
    }

    // проверка видимости информации о владельце аккаунта
    public boolean checkVisibleNawAccount() {
        return nawAccount.hover().is(Condition.visible);
    }

}
