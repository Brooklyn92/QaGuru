package lesson6.hw6;

public class Car {

    private String brand;
    private String model;
    private int price;

    public Car(String brand){
        this.brand=brand;
        System.out.println();
    }

    public void setModel(String model) {
        this.model=model;
    }
    public void setPrice(int price) {
        this.price=price;
    }

    public void carInCarShowroom(){
        System.out.println(brand + " " + model + " по цене " + price + " рублей");
    }
}
