package hw2;

import java.util.Scanner;

public class CalcParams {
    static Scanner scanner = new Scanner(System.in);

    public int getInt() {
        System.out.println("Введите число:");
        int num = scanner.nextInt();
        return num;
    }

    public char getOperation() {
        System.out.println("Введите операцию ( +, -, /, *:");
        char operation= scanner.next().charAt(0);
        return operation;
    }

    public int calc(int num1, int num2, char operation) {
        int result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());//рекурсия
        }
        return result;
    }

}






















