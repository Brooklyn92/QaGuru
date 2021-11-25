package hw2;

public class Calc{

    public static void main(String[] args) {
        CalcParams calcParams1 =new CalcParams();
            int num1=calcParams1.getInt();
            int num2=calcParams1.getInt();
            char operation = calcParams1.getOperation();
            int result = calcParams1.calc(num1, num2, operation);
            System.out.println("Результат операции: " + result);

    }
}
