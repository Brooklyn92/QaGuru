package lesson6.hw6;

public class CarShowroom {
        public static void main(String[] args) {
            Director.sayFirstNameAndLastName();
            Car toyota=new Car("Toyota");
            toyota.setModel("Kamry");
            toyota.setPrice(2500000);
            toyota.carInCarShowroom();
            toyota.setModel("Tundra");
            toyota.setPrice(3500000);
            toyota.carInCarShowroom();
            Car ford = new Car("Ford");
            ford.setModel("Mustang");
            ford.setPrice(3555000);
            ford.carInCarShowroom();
        }
    static class Director {
        static String firstName = "Алексей";
        static String lastName = "Иванов";
        public static void sayFirstNameAndLastName() {
            System.out.println("Здравствуйте, меня зовут " + firstName + " " + lastName + " ,я являюсь директором автосалона");
            System.out.println("У нас в автосалоне имеются следующие автомобили:");
        }
    }

}

