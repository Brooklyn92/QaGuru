package lesson6;

    class Human {
        public static String commonName = "Человек";

        private int age; // 0
        private int weight; // 0
        private String name;
        Head head;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Head getHead() {
            return head;
        }

        public void setHead(Head head) {
            this.head = head;
        }

        static class Head {
            static String name = "";
            String nonStaticName;

            public void sayName() {
                System.out.println(nonStaticName);
            }

            public static void sayNameStatic() {
                System.out.println(name);
            }
        }

        public Human(int weight) {
            this.weight = weight;
        }

        public Human(int weight, String name) {
            this.weight = weight;
            this.name = name;
        }

        public void sayName() {
            System.out.println("Имя: " + name);
        }

        public void sayAge() {
            System.out.println("Возраст: " + age);
        }

        public void sayWeight() {
            System.out.println("Вес: " + weight);
        }

        public void incrementAge() {
            this.getClass().getName();

            age = age + 1;
        }

        public static void sayClassName() {
            System.out.println(Human.class.getName());
        }

}
