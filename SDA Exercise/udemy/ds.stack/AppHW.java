

public class AppHW {
    public static void main(String[] args){
        StackHW myStack = new StackHW(3);
        // myStack.push(20);
        // myStack.push(30);
        // myStack.push(40);
        // myStack.push(50);

        // while(!myStack.isEmpty()){
        //     long value = myStack.pop();
        //     System.out.println(value);
        // }

        System.out.println(reverseString("Hello"));
    }

    public static String reverseString(String str){
        int stackSize = str.length();
        StackHW myStack = new StackHW(stackSize);
        for(int i = 0; i < stackSize; i++){
            char chr = str.charAt(i);
            myStack.push(chr);
        }
        String value = "";
        while(!myStack.isEmpty()){
            char chr = myStack.pop();
            value = value + chr;
        }
        return value;
    }
}