public class Adt{
    public static void main(String args[]){
        Counter counter1 = new Counter("counter1");
        counter1.increment();
        counter1.increment();



        System.out.println(counter1.getCurrentValue());
    }
}