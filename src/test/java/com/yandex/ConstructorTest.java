package com.yandex;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {

    // Проверь, что работают переходы к разделам: «Булки», «Соусы», «Начинки»

    @Test
    @DisplayName("Transitions to the sections of the constructor")
    @Description("Проверяем, что работают переходы к разделам: «Булки», «Соусы», «Начинки»")
    public void checkTheTransitionToSectionsTest() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.clickToConstructor();
        mainPage.checkBuns();
        mainPage.checkFluorescentBun();
        mainPage.checkSauces();
        mainPage.checkSpicyX();
        mainPage.checkFillings();
        mainPage.checkProtostomiaMeat();
    }
}
