package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pageElements.Main;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.data.Utils.waitDisplayed;

public class MainSteps {
    Main main = new Main();

    public void checkingMainPage(){
        Allure.step("Проверка, что это главная страница");
        main.inRoot.perform(waitDisplayed(R.id.all_news_text_view, 5000));
        main.allNews.check(matches(isDisplayed()));
    }

    public void goPageAllNews(){
        Allure.step("Переход на страницу ВСЕ НОВОСТИ");
        main.allNews.perform(click());
        main.newsPage.check(matches(isDisplayed()));
    }

    public void goMenuNews() {
        Allure.step("Переход в меню вкладки Новости");
        main.mainMenuButton.perform(click());
        main.news.perform(click());
        main.newsPage.check(matches(isDisplayed()));
    }

    public void goMenuAbout() {
        Allure.step("Переход в меню вкладки О приложении");
        main.mainMenuButton.perform(click());
        main.about.perform(click());
        main.aboutPage.check(matches(isDisplayed()));
    }

    public void goHomePageOfNews() {
        Allure.step("Переход на страницу Главная со страницы Новости");
        main.mainMenuButton.perform(click());
        main.news.perform(click());
        main.mainMenuButton.perform(click());
        main.homePage.perform(click());
        main.allNews.check(matches(isDisplayed()));
    }

    public void goHomePageOfAllNews() {
        Allure.step("Переход на страницу Главная со страницы Все Новости");
        main.allNews.perform(click());
        main.mainMenuButton.perform(click());
        main.homePage.perform(click());
        main.allNews.check(matches(isDisplayed()));
    }
    public void logOut() {
        Allure.step("Выход из аккаунта");
        main.profile.perform(click());
        main.logOut.perform(click());
        main.authorizationPage.check(matches(isDisplayed()));
    }
}