package lesson6;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HelloWorld {
    boolean aBoolean = false; //*
    char aChar = '§';
    byte aByte = 1;
    short aShort = 1;
    int aInt = 1; //*
    long aLong = 1L;
    float aFloat = 1.0F;
    double aDouble = 1.0D; //*

    // модификатор доступа ||static -> возвращаемое значение -> имя -> (аргументы)
    public static void main(String[] args) {
        int age = 10;

        String message = "HelloWorld!";

        Human dima = new Human(4, "Дима");
        Human alex = new Human(5, "Александр");

        dima.setAge(1);
        alex.setAge(32);

        dima.sayName();
        dima.sayAge();
        dima.sayWeight();
        dima.incrementAge();
        dima.commonName = "Не человек";

        Configuration.browser = "chrome";

        Human.sayClassName();

        alex.sayName();
        alex.sayAge();
        alex.sayWeight();
        System.out.println(message);

    }

    int summ(int i, int i1) {
        return i + i1;
    }
}
