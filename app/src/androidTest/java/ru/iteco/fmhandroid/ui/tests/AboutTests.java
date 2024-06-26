package ru.iteco.fmhandroid.ui.tests;

import androidx.test.rule.ActivityTestRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;


@RunWith(AllureAndroidJUnit4.class)
public class AboutTests {
    AuthorizationSteps auth = new AuthorizationSteps();
    MainSteps main = new MainSteps();
    AboutSteps about = new AboutSteps();


    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void setUp() {
        auth.checkLogIn();
        main.checkingMainPage();
    }

    @Test
    @DisplayName("Ссылка Политика конфиденциальности")
    public void transitionToPrivacyPolicy(){
        main.goMenuAbout();
        about.checkingAboutPage();
        about.checkingUrlPrivacy();
        about.backButton();
    }

    @Test
    @DisplayName("Ссылка Пользовательское соглашение")
    public void transitionToTermsOfUse(){
        main.goMenuAbout();
        about.checkingAboutPage();
        about.checkingUrlTerms();
        about.backButton();
    }
}
