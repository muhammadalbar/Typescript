public class Animal{
    String name;
    int age;
    String kind;

    public Animal(String name, int age, String kind){
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    public void speak(){
        System.out.println("Animal cannot speak, so i introduce you");
        System.out.println("This is " + name);
        System.out.println("He is " + age + " years old");
        System.out.println("He is a " + kind);
    }

    public void eat(){
        System.out.println(name + " is eating, Hmm.. Yummy!");
    }
}