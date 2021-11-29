package hw3;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop{
   final SelenideElement column1=$("#column-a");
   final SelenideElement column2=$("#column-b");
   final SelenideElement column= $x("//div[@class='column']");

    @BeforeAll
    public static void setting(){
        //Configuration.startMaximized=true;
        Configuration.holdBrowserOpen=true;
    }
    @Test
    public void dragAndDropTesting(){
        //Открыть страницу https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //actions().moveToElement(column1).clickAndHold().moveByOffset(400,0).release().perform();
        //Убеждаемся, что первый элемент имеется значение А
        column.shouldHave(text("A"));
        // Меняем местами А и В
        $(column1).dragAndDropTo(column2);
        //Убеждаемся, что первый элемент имеется значение В
        column.shouldHave(text("B"));
    }
}
