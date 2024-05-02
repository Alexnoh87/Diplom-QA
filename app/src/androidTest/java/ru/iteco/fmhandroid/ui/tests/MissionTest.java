package ru.iteco.fmhandroid.ui.tests;

import androidx.test.rule.ActivityTestRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.MissionSteps;

@RunWith(AllureAndroidJUnit4.class)
public class MissionTest {
    AuthorizationSteps auth = new AuthorizationSteps();
    MissionSteps mission = new MissionSteps();
    MainSteps main = new MainSteps();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void setUp() {
        auth.checkLogIn();
        main.checkingMainPage();
    }

    @Test
    @DisplayName("Страница Цитаты")
    public void pageOurMission(){
        mission.goPageOurMission();
    }

    @Test
    @DisplayName("Cтраница Главная")
    public void openHomePageOfNews(){
        mission.goHomePage();
    }

    @Test
    @DisplayName("Страница Новости")
    public void pageNews(){
        mission.goNewsPage();
    }

    @Test
    @DisplayName("Страница О приложении")
    public void pageAbout(){
        mission.goAboutPage();
    }
}
