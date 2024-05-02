package ru.iteco.fmhandroid.ui.steps;

import static ru.iteco.fmhandroid.ui.data.Data.validLogin;
import static ru.iteco.fmhandroid.ui.data.Data.validPassword;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Utils;
import ru.iteco.fmhandroid.ui.pageElements.Authorization;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.Utils.waitDisplayed;

public class AuthorizationSteps {

    Authorization auth = new Authorization();
    MainSteps main = new MainSteps();
    Utils utils = new Utils();

    public void checkLogIn() {
        Allure.step("Вход в аккаунт, если не авторизован.");
        if (utils.LogIn()) {
            validAuthorization();
        }
    }
    public void checkingAuthorization() {
        Allure.step("Проверка oкна авторизации");
        auth.authScreen.check(matches(isDisplayed()));
    }

    public void waitAutorization(){
        Allure.step("Ожидание загрузки");
        auth.inRoot.perform(waitDisplayed(R.id.container_custom_app_bar_include_on_fragment_main, 10000));
    }

    public void loginField(String login) {
        Allure.step("Заполнить поле логин");
        auth.login.check(matches(isEnabled()));
        auth.login.perform(replaceText(login));
    }

    public void passwordField(String password) {
        Allure.step("Заполнить поле пароль");
        auth.password.check(matches(isEnabled()));
        auth.password.perform(replaceText(password));
    }

    public void buttonClick() {
        Allure.step("Кликнуть по кнопке ВОЙТИ");
        auth.enterButton.perform(click());
    }

    public void validAuthorization(){
        Allure.step("Заполнить поле логин");
        auth.login.check(matches(isEnabled()));
        auth.login.perform(replaceText(validLogin));
        Allure.step("Заполнить поле пароль");
        auth.password.check(matches(isEnabled()));
        auth.password.perform(replaceText(validPassword));
        Allure.step("Кликнуть по кнопке ВОЙТИ");
        auth.enterButton.perform(click());
        main.checkingMainPage();
    }
    public void emptyLoginOrPassword(){
        Allure.step("Пустой логин или пароль");
        onView(allOf(withContentDescription("Логин и пароль не могут быть пустыми"), isDisplayed()));
    }
    public void invalidLoginOrPassword(){
        Allure.step("Неверный логин или пароль");
        onView(allOf(withContentDescription("Что-то пошло не так. Попробуйте позднее."), isDisplayed()));
    }
}
