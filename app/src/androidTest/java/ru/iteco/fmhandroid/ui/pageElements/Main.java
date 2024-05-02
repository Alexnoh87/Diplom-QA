package ru.iteco.fmhandroid.ui.pageElements;

import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

public class Main {
    public ViewInteraction mainMenuButton = onView(withId(R.id.main_menu_image_button));
    public ViewInteraction allNews = onView(withId(R.id.all_news_text_view));
    public ViewInteraction homePage = onView(withText(R.string.main));
    public ViewInteraction news = onView(withText(R.string.news));
    public ViewInteraction about = onView(withText(R.string.about));
    public ViewInteraction profile = onView(withId(R.id.authorization_image_button));
    public ViewInteraction logOut = onView((withText(R.string.log_out)));
    public ViewInteraction authorizationPage = onView(allOf(withText(R.string.authorization)));
    public ViewInteraction newsPage = onView(withId(R.id.news_list_swipe_refresh));
    public ViewInteraction aboutPage = onView(withId(R.id.about_version_title_text_view));
    public ViewInteraction inRoot = onView(isRoot());
}
