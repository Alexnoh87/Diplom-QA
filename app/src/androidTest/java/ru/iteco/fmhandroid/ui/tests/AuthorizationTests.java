package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.Data.validLogin;
import static ru.iteco.fmhandroid.ui.data.Data.validPassword;
import static ru.iteco.fmhandroid.ui.data.Data.invalidLogin;
import static ru.iteco.fmhandroid.ui.data.Data.invalidPassword;
import static ru.iteco.fmhandroid.ui.data.Data.emptyLogin;
import static ru.iteco.fmhandroid.ui.data.Data.emptyPassword;
import static ru.iteco.fmhandroid.ui.data.Data.charactersLogin;
import static ru.iteco.fmhandroid.ui.data.Data.charactersPassword;
import static ru.iteco.fmhandroid.ui.data.Data.spacesLogin;
import static ru.iteco.fmhandroid.ui.data.Data.spacesPassword;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.AppActivity;

@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationTests {
    AuthorizationSteps auth = new AuthorizationSteps();
    MainSteps main = new MainSteps();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authCheck() {
        auth.waitAutorization();
        try {
            auth.checkingAuthorization();
        } catch (NoMatchingViewException e) {
            main.logOut();
        }
    }

    @Test
    @DisplayName("Авторизация с валидными данными (тестовыми)")
    public void validAuthorization(){
        auth.checkingAuthorization();
        auth.validAuthorization();
        main.logOut();
    }

    @Test
    @DisplayName("Авторизация с невалидным логином")
    public void invalidLogin(){
        auth.checkingAuthorization();
        auth.loginField(invalidLogin);
        auth.passwordField(validPassword);
        auth.buttonClick();
        auth.invalidLoginOrPassword();
    }

    @Test
    @DisplayName("Авторизация с невалидным паролем")
    public void invalidPassword(){
        auth.checkingAuthorization();
        auth.loginField(validLogin);
        auth.passwordField(invalidPassword);
        auth.buttonClick();
        auth.invalidLoginOrPassword();
    }

    @Test
    @DisplayName("Авторизация с пустым полем Логин")
    public void emptyLogin(){
        auth.checkingAuthorization();
        auth.loginField(emptyLogin);
        auth.passwordField(validPassword);
        auth.buttonClick();
        auth.emptyLoginOrPassword();
    }

    @Test
    @DisplayName("Авторизация с пустым полем Пароль")
    public void emptyPassword(){
        auth.checkingAuthorization();
        auth.loginField(validLogin);
        auth.passwordField(emptyPassword);
        auth.buttonClick();
        auth.emptyLoginOrPassword();
    }

    @Test
    @DisplayName("Авторизация при пустой форме")
    public void emptyAuthorization() {
        auth.checkingAuthorization();
        auth.buttonClick();
        auth.emptyLoginOrPassword();
    }

    @Test
    @DisplayName("Авторизация с символами в поле Логин")
    public void loginCharacters(){
        auth.checkingAuthorization();
        auth.loginField(charactersLogin);
        auth.passwordField(validPassword);
        auth.buttonClick();
        auth.invalidLoginOrPassword();
    }

    @Test
    @DisplayName("Авторизация с символами в поле Пароль")
    public void passwordCharacters(){
        auth.checkingAuthorization();
        auth.loginField(validLogin);
        auth.passwordField(charactersPassword);
        auth.buttonClick();
        auth.invalidLoginOrPassword();
    }

    @Test
    @DisplayName("Авторизация с пробелами в поле Логин")
    public void loginSpace(){
        auth.checkingAuthorization();
        auth.loginField(spacesLogin);
        auth.passwordField(validPassword);
        auth.buttonClick();
        auth.invalidLoginOrPassword();
    }

    @Test
    @DisplayName("Авторизация с пробелами в поле Пароль")
    public void passwordSpace(){
        auth.checkingAuthorization();
        auth.loginField(validLogin);
        auth.passwordField(spacesPassword);
        auth.buttonClick();
        auth.invalidLoginOrPassword();
    }
}
