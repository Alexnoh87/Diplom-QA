package ru.iteco.fmhandroid.ui.pageElements;

import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
public class Mission {

    public ViewInteraction allMission = onView(withId(R.id.our_mission_image_button));
    public ViewInteraction missionPage = onView(allOf(withText(R.string.our_mission_title_text)));
}
