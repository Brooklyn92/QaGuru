package hw4.pages.components;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day,String month, String year){
        $(byXpath("//input[@id='dateOfBirthInput']")).click();
        $(byXpath("//select[@class='react-datepicker__month-select']")).selectOption(month); //selectOption - используется для выбора значения из выпадающего списка.
        $(byXpath("//select[@class='react-datepicker__year-select']")).selectOption(year);
        $(".react-datepicker__day--0" + day +":not(.react-datepicker__day--outside-month)").click();
    }
}
