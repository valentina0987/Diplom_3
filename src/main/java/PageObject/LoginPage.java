package PageObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    public final String EMAIL = "valentina.zamotaeva@yandex.ru";
    public final String PASSWORD = "010101";


    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement userEmailField;

    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement userPasswordField;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement userLoginButton;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registrationButton;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Восстановить пароль')]")
    private SelenideElement recoverPasswordButton;

    @FindBy(how = How.XPATH, using = "//form[@class='Auth_form__3qKeq mb-20']")
    private SelenideElement authForm;


    @Step("Ввод email зарегистрированного пользователя")
    public void setEmail(String email) {
        userEmailField.setValue(email);
    }

    @Step("Ввод пароля зарегистрированного пользователя")
    public void setPassword(String password) {
        userPasswordField.setValue(password);
    }

    @Step("Клик на кнопку входа")
    public void clickEntryButton() {
        userLoginButton.click();
    }

    @Step("Прохождение авторизации зарегистрированного пользователя")
    public void sendEmailAndPassword(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickEntryButton();
    }

    @Step("Ожидание входа в систему")
    public void waitingForLogin() {
        userLoginButton.shouldBe(Condition.hidden);
    }

    @Step ("Проверяем видна ли кнопка 'Вход'")
    public boolean checkVisibleTitleLogin(){
        return userLoginButton.hover().is(Condition.visible);
    }
}
