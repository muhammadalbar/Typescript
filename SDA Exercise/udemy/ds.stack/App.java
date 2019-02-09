

public class App {
    public static void main(String[] args){
        Stack myStack = new Stack(3);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);
        myStack.push(50);

        while(!myStack.isEmpty()){
            long value = myStack.pop();
            System.out.println(value);
        }
    }
}