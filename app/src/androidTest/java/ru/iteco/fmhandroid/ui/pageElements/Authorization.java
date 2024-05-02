package ru.iteco.fmhandroid.ui.pageElements;

import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.core.AllOf.allOf;

public class Authorization {
    public ViewInteraction authScreen = onView(allOf(withText(R.string.authorization), withParent(withParent(withId(R.id.nav_host_fragment)))));
    public ViewInteraction login = onView(allOf(withHint(R.string.login), withParent(withParent(withId(R.id.login_text_input_layout)))));
    public ViewInteraction password = onView(allOf(withHint(R.string.password), withParent(withParent(withId(R.id.password_text_input_layout)))));
    public ViewInteraction enterButton = onView(allOf(withId(R.id.enter_button)));
    public ViewInteraction inRoot = onView(isRoot());

    public int enterButtonId = R.id.enter_button;

}
