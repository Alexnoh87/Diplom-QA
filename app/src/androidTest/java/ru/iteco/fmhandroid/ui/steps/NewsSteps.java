package ru.iteco.fmhandroid.ui.steps;

import static ru.iteco.fmhandroid.ui.data.Data.emptyFieldsError;
import static ru.iteco.fmhandroid.ui.data.Data.notFromListCategoryError;
import static ru.iteco.fmhandroid.ui.data.Utils.waitDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pageElements.News;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import org.hamcrest.Matchers;

public class NewsSteps {
    News news = new News();

    public void checkNewsPage() {
        Allure.step("Проверить, что это oкно новостей");
        news.newsPage.check(matches(isDisplayed()));
    }

    public void checkFilterNews() {
        Allure.step("Проверить, что это oкно Фильтровать новости");
        news.filterPage.check(matches(isDisplayed()));
    }

    public void sortNews() {
        Allure.step("Нажать кнопку Сортировка");
        news.sort.perform(click());
    }

    public void filterNews() {
        Allure.step("Нажать кнопку Фильтровать новости");
        news.filter.perform(click());
    }

    public void editNews() {
        Allure.step("Нажать кнопку редактирования");
        news.edit.perform(click());
    }

    public void isFilterScreen() {
        Allure.step("Проверить, что это окно Фильтровать новости");
        news.filterPage.check(matches(isDisplayed()));
    }

    public void selectFilterStartDate() {
        Allure.step("Выбрать Дату ОТ");
        news.startDate.perform(click());
    }

    public void selectFilterEndDate() {
        Allure.step("Выбрать Дату ДО");
        news.endDate.perform(click());
    }

    public void applyNews() {
        Allure.step("Подтверждение фильтрации новостей");
        news.filterButton.perform(click());
    }

    public void outputMessage() {
        Allure.step("Вывод сообщения об ошибке");
        news.message.check(matches(isDisplayed()));
    }

    public void emptyFields(){
        Allure.step("Проверка пустых полей");
        onView(Matchers.allOf(withContentDescription(emptyFieldsError), isDisplayed()));
    }

    public void notFromListCategory(){
        Allure.step("Категория не из списка");
        onView(Matchers.allOf(withContentDescription(notFromListCategoryError), isDisplayed()));
    }

    public void dateCreatingNews(){
        Allure.step("Выбор даты");
        news.dateCreating.perform(click());
    }
    public void timeCreatingNews(){
        Allure.step("Выбор времени");
        news.timeCreation.perform(click());
    }
    public void clickOkButton(){
        Allure.step("Нажать кнопку ОК");
        news.okButton.perform(click());
    }

    public void checkingControlPanelPage() {
        Allure.step("Проверить, что это oкно Панели управления новостями");
        news.inRoot.perform(waitDisplayed(R.id.news_list_recycler_view, 5000));
        news.controlPanelPage.check(matches(isDisplayed()));
    }

    public void sortNewsControlPanel() {
        Allure.step("Нажать кнопку сортировка новостей");
        news.sortControlPanel.perform(click());
    }

    public void createNews() {
        Allure.step("Нажать кнопку создания новости");
        news.createControlPanel.perform(click());
    }

    public void checkingCreateNewsPage() {
        Allure.step("Проверить, что это oкно Создания новости");
        news.creatingPage.check(matches(isDisplayed()));
    }

    public void selectCategory(String text) {
        Allure.step("Выбрать категорию для создания новости");
        news.createCategory.perform(click());
        news.createCategory.perform(replaceText(text));
    }

    public void enterTittle(String text) {
        Allure.step("Ввод заголовка");
        news.createTitle.perform(replaceText(text));
    }

    public void enterDescription(String description) {
        Allure.step("Ввод описания");
        news.createDescription.perform(replaceText(description));
    }

    public void saveButton() {
        Allure.step("Нажать на кнопку сохранить");
        news.saveButton.perform(click());
    }

    public void cancelButton() {
        Allure.step("Нажать на кнопку отменить");
        news.cancelButton.perform(click());
    }
}
