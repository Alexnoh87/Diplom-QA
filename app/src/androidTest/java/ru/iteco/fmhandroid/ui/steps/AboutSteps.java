package ru.iteco.fmhandroid.ui.steps;

import static ru.iteco.fmhandroid.ui.data.Data.urlPrivacyPolicy;
import static ru.iteco.fmhandroid.ui.data.Data.urlTermsOfUse;

import android.app.Instrumentation;
import android.content.Intent;

import androidx.test.espresso.intent.Intents;
import io.qameta.allure.kotlin.Allure;
import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.ui.pageElements.About;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.core.AllOf.allOf;

public class AboutSteps {
    About about = new About();

    public void checkingAboutPage() {
        Allure.step("Проверить, что это страница О приложении");
        about.title.check(matches(isDisplayed()));
    }

    public void checkingUrlPrivacy() {
        Allure.step("Ссылка Политики конфиденциальности");
        Intents.init();
        Matcher<Intent> expectedIntent = allOf(hasAction(Intent.ACTION_VIEW), hasData(urlPrivacyPolicy));
        intending(expectedIntent).respondWith(new Instrumentation.ActivityResult(0, null));
        about.privacy.perform(click());
        intended(expectedIntent);
        Intents.release();
    }

    public void checkingUrlTerms() {
        Allure.step("Ссылка Пользовательского соглашения");
        Intents.init();
        Matcher<Intent> expectedIntent = allOf(hasAction(Intent.ACTION_VIEW), hasData(urlTermsOfUse));
        intending(expectedIntent).respondWith(new Instrumentation.ActivityResult(0, null));
        about.terms.perform(click());
        intended(expectedIntent);
        Intents.release();
    }

    public void backButton() {
        Allure.step("Возврат к предыдущей странице");
        about.backButton.perform(click());
    }
}
