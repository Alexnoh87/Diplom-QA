package ru.iteco.fmhandroid.ui.pageElements;

import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;
import static androidx.test.espresso.Espresso.onView;
import static org.hamcrest.core.AllOf.allOf;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.hamcrest.Matchers;

public class News {
    public ViewInteraction newsPage = onView(withId(R.id.container_list_news_include));
    public ViewInteraction sort = onView(withId(R.id.sort_news_material_button));
    public ViewInteraction filter = onView(withId(R.id.filter_news_material_button));
    public ViewInteraction edit = onView(withId(R.id.edit_news_material_button));
    public ViewInteraction filterPage = onView(withText(R.string.filter_news));
    public ViewInteraction startDate = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public ViewInteraction endDate = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    public ViewInteraction filterButton = onView(withId(R.id.filter_button));
    public ViewInteraction dateCreating = onView(allOf(withId(R.id.news_item_publish_date_text_input_edit_text)));
    public ViewInteraction timeCreation = onView(allOf(withId(R.id.news_item_publish_time_text_input_edit_text)));
    public ViewInteraction okButton = onView(withId(android.R.id.button1));
    public ViewInteraction message = onView(withId(android.R.id.message));
    public ViewInteraction controlPanelPage = onView(allOf(withText(R.string.news_control_panel)));
    public ViewInteraction sortControlPanel = onView(withId(R.id.sort_news_material_button));
    public ViewInteraction createControlPanel = onView(withId(R.id.add_news_image_view));
    public ViewInteraction saveButton = onView(withId(R.id.save_button));
    public ViewInteraction cancelButton = onView(withId(R.id.cancel_button));
    public ViewInteraction creatingPage = onView(withId(R.id.container_custom_app_bar_include_on_fragment_create_edit_news));
    public ViewInteraction createCategory = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction createTitle = onView(withId(R.id.news_item_title_text_input_edit_text));
    public ViewInteraction createDescription = onView(withId(R.id.news_item_description_text_input_edit_text));
    public ViewInteraction inRoot = onView(isRoot());
}
