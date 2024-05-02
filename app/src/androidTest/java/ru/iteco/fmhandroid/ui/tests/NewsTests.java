package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.Data.category;
import static ru.iteco.fmhandroid.ui.data.Data.emptyCategory;
import static ru.iteco.fmhandroid.ui.data.Data.notFromListCategory;
import static ru.iteco.fmhandroid.ui.data.Data.emptyDescription;
import static ru.iteco.fmhandroid.ui.data.Data.description;
import static ru.iteco.fmhandroid.ui.data.Data.tittle;
import static ru.iteco.fmhandroid.ui.data.Data.emptyTittle;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
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
import ru.iteco.fmhandroid.ui.steps.NewsSteps;;

@RunWith(AllureAndroidJUnit4.class)
public class NewsTests {
    AuthorizationSteps auth = new AuthorizationSteps();
    MainSteps main = new MainSteps();
    NewsSteps news = new NewsSteps();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void setUp() {
        auth.checkLogIn();
        main.checkingMainPage();
    }

    @Test
    @DisplayName("Сортировка новостей")
    public void sortNews() {
        main.goMenuNews();
        news.sortNews();
        news.checkNewsPage();
    }

    @Test
    @DisplayName("Переход на страницу Фильтровать новости")
    public void filterNewsAdd() {
        main.goMenuNews();
        news.checkNewsPage();
        news.filterNews();
        news.checkFilterNews();
    }

    @Test
    @DisplayName("Фильтрация новостей только по дате ОТ")
    public void filterStartDate() {
        main.goMenuNews();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterStartDate();
        news.clickOkButton();
        news.applyNews();
        news.outputMessage();
    }

    @Test
    @DisplayName("Фильтрация новостей только по дате ДО")
    public void filterEndDate() {
        main.goMenuNews();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterEndDate();
        news.clickOkButton();
        news.applyNews();
        news.outputMessage();
    }

    @Test
    @DisplayName("Проверка кнопки Отмена на странице Фильтровать новости")
    public void checkCancelButton() {
        main.goMenuNews();
        news.checkNewsPage();
        news.filterNews();
        news.cancelButton();
        news.checkNewsPage();
    }

    @Test
    @DisplayName("Переход на страницу Фильтровать новости из раздела Панель управления")
    public void filterNewsControlPanel() {
        main.goMenuNews();
        news.editNews();
        news.filterNews();
        news.checkFilterNews();
    }

    @Test
    @DisplayName("Фильтрация новостей только по дате ОТ со страницы Панель управления")
    public void filterStartDateControlPanel() {
        main.goMenuNews();
        news.editNews();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterStartDate();
        news.clickOkButton();
        news.applyNews();
        news.outputMessage();
    }

    @Test
    @DisplayName("Фильтрация новостей только по дате ДО со страницы Панель управления")
    public void filterEndDateControlPanel() {
        main.goMenuNews();
        news.editNews();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterEndDate();
        news.clickOkButton();
        news.applyNews();
        news.outputMessage();
    }

    @Test
    @DisplayName("Проверка кнопки Отмена на странице Фильтровать новости из Панели управления")
    public void checkCancelButtonControlPanel() {
        main.goMenuNews();
        news.editNews();
        news.filterNews();
        news.cancelButton();
        news.checkingControlPanelPage();
    }

    @Test
    @DisplayName("Переход на страницу Создать новость")
    public void createNews() {
        main.goMenuNews();
        news.editNews();
        news.createNews();
        news.checkingCreateNewsPage();
    }

    @Test
    @DisplayName("Сортировка новостей из Панели инструментов")
    public void sortNewsOnControlPanel() {
        main.goMenuNews();
        news.editNews();
        news.sortNewsControlPanel();
        news.checkingControlPanelPage();
    }

    @Test
    @DisplayName("Создание новости")
    public void createNewsOnControlPanel() {
        main.goMenuNews();
        news.editNews();
        news.createNews();
        news.selectCategory(category);
        news.enterTittle(tittle);
        news.dateCreatingNews();
        news.clickOkButton();
        news.timeCreatingNews();
        news.clickOkButton();
        news.enterDescription(description);
        closeSoftKeyboard();
        news.saveButton();
        news.checkingControlPanelPage();
    }

    @Test
    @DisplayName("Создание новости без категории")
    public void createNewsWithEmptyCategory() {
        main.goMenuNews();
        news.editNews();
        news.createNews();
        news.selectCategory(emptyCategory);
        news.enterTittle(tittle);
        news.dateCreatingNews();
        news.clickOkButton();
        news.timeCreatingNews();
        news.clickOkButton();
        news.enterDescription(description);
        closeSoftKeyboard();
        news.saveButton();
        news.emptyFields();
    }

    @Test
    @DisplayName("Создание новости без заголовка")
    public void createNewsWithEmptyTittle() {
        main.goMenuNews();
        news.editNews();
        news.createNews();
        news.selectCategory(category);
        news.enterTittle(emptyTittle);
        news.dateCreatingNews();
        news.clickOkButton();
        news.timeCreatingNews();
        news.clickOkButton();
        news.enterDescription(description);
        closeSoftKeyboard();
        news.saveButton();
        news.emptyFields();
    }

    @Test
    @DisplayName("Создание новости без описания")
    public void createNewsWithEmptyDescription() {
        main.goMenuNews();
        news.editNews();
        news.createNews();
        news.selectCategory(category);
        news.enterTittle(tittle);
        news.dateCreatingNews();
        news.clickOkButton();
        news.timeCreatingNews();
        news.clickOkButton();
        news.enterDescription(emptyDescription);
        closeSoftKeyboard();
        news.saveButton();
        news.emptyFields();
    }

    @Test
    @DisplayName("Создание новости без даты")
    public void createNewsWithEmptyDate() {
        main.goMenuNews();
        news.editNews();
        news.createNews();
        news.selectCategory(category);
        news.enterTittle(tittle);
        news.timeCreatingNews();
        news.clickOkButton();
        news.enterDescription(description);
        closeSoftKeyboard();
        news.saveButton();
        news.emptyFields();
    }

    @Test
    @DisplayName("Создание новости без времени")
    public void createNewsWithEmptyTime() {
        main.goMenuNews();
        news.editNews();
        news.createNews();
        news.selectCategory(category);
        news.enterTittle(tittle);
        news.dateCreatingNews();
        news.clickOkButton();
        news.enterDescription(description);
        closeSoftKeyboard();
        news.saveButton();
        news.emptyFields();
    }

    @Test
    @DisplayName("Создание новости с категорией не из списка")
    public void createNewsWithNotFromListCategory() {
        main.goMenuNews();
        news.editNews();
        news.createNews();
        news.selectCategory(notFromListCategory);
        news.enterTittle(tittle);
        news.dateCreatingNews();
        news.clickOkButton();
        news.timeCreatingNews();
        news.clickOkButton();
        news.enterDescription(description);
        closeSoftKeyboard();
        news.saveButton();
        news.notFromListCategory();
    }
}