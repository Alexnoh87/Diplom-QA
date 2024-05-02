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

@RunWith(AllureAndroidJUnit4.class)
public class MainTests {
    AuthorizationSteps auth = new AuthorizationSteps();
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
    @DisplayName("Ссылка Все Новости")
    public void AllNews(){
        main.goPageAllNews();
    }

    @Test
    @DisplayName("Страница Новости")
    public void pageNews(){
        main.goMenuNews();
    }

    @Test
    @DisplayName("Страница О приложении")
    public void pageAbout(){
        main.goMenuAbout();
    }

    @Test
    @DisplayName("Переход на главную со страницы Новости")
    public void openHomePageOfNews(){
        main.goHomePageOfNews();
    }

    @Test
    @DisplayName("Переход на главную со страницы Все Новости")
    public void openHomePageOfAllNews(){
        main.goHomePageOfAllNews();
    }
}
