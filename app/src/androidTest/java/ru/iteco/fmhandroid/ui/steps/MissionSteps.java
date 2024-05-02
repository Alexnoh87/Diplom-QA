package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.pageElements.Main;
import ru.iteco.fmhandroid.ui.pageElements.Mission;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

public class MissionSteps {

    Mission mission = new Mission();
    Main main = new Main();

    public void goPageOurMission(){
        Allure.step("Переход на страницу ЦИТАТЫ");
        mission.allMission.perform(click());
        mission.missionPage.check(matches(isDisplayed()));
    }

    public void goHomePage() {
        Allure.step("Переход на страницу Главная");
        mission.allMission.perform(click());
        main.mainMenuButton.perform(click());
        main.homePage.perform(click());
        main.allNews.check(matches(isDisplayed()));
    }

    public void goNewsPage() {
        Allure.step("Переход на страницу Новости");
        mission.allMission.perform(click());
        main.mainMenuButton.perform(click());
        main.news.perform(click());
        main.newsPage.check(matches(isDisplayed()));
    }

    public void goAboutPage() {
        Allure.step("Переход на страницу О приложении");
        mission.allMission.perform(click());
        main.mainMenuButton.perform(click());
        main.about.perform(click());
        main.aboutPage.check(matches(isDisplayed()));
    }
}
