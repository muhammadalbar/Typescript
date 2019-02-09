public class Zoo{
    public static void main(String args[]){
        Animal animal1 = new Animal("Bob", 4, "Lion");
        Animal animal2 = new Animal("Mumun", 3, "Cat");
        Animal animal3 = new Animal("Upin", 5, "Rabbit");

        animal1.speak();
        animal2.speak();
        animal3.speak();
        animal1.eat();
    }
}