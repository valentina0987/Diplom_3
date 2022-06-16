package PageObject;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

    public static final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    public final String NAME = "test" + RandomStringUtils.randomAlphabetic(3);
    public final String EMAIL = "test" + RandomStringUtils.randomAlphabetic(3) + "@yandex.ru";
    public final String PASSWORD = "ABCDEF";
    public final String INCORRECT_PASSWORD = "ABCDE";

    //@FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    //private SelenideElement startRegistration;
    // не пойму, используется она все таки где-то или нет

    @FindBy(how = How.XPATH, using = ".//label[text() = 'Имя']/../input")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH, using = ".//label[text() = 'Email']/../input")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = ".//label[text() = 'Пароль']/../input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//button[text() = 'Зарегистрироваться']")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement entryButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    private SelenideElement incorrectPasswordWarning;


    @Step("Ввод имени нового пользователя")
    public void setName(String name) {
        nameField.setValue(name);
    }

    @Step("Ввод email нового пользователя")
    public void setEmail(String email) {
        emailField.setValue(email);
    }

    @Step("Ввод пароля нового пользователя")
    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    @Step("Нажатие на кнопку регистрации")
    public void clickRegistrationButton() {
        registerButton.click();
    }

    @Step("Прохождение регистрации нового пользователя")
    public void newUserRegistration(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegistrationButton();
    }

    @Step("Проверка предупреждения о некорретном пароле")
    public boolean checkIncorrectPasswordSign() {
        return incorrectPasswordWarning.isDisplayed();
    }

    @Step("Проверка видимости кнопки 'Войти'")
    public boolean checkEntryButton() {
        return entryButton.isDisplayed();
    }

    @Step("Клик на кнопку 'Войти'")
    public void clickEntryButton() {
        entryButton.click();
    }

    @Step("Ожидание после регистрации")
    public void waitAfterRegistration() {
    }
}

