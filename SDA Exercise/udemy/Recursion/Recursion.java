public class Recursion{
    public static void main(String[] args){
        reduceByOne(10);
    }

    public static void reduceByOne(int n){
        // base case
        if(n >= 0){
            reduceByOne(n-1);
        }
        System.out.println("Completed call : " + n);
    }
}