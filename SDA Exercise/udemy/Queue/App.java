public class App{
    public static void main(String[] args){
        Queue myQueue = new Queue(5);
        myQueue.insert(20);
        myQueue.insert(60);
        myQueue.insert(50);
        myQueue.insert(40);
        myQueue.insert(30);
        myQueue.insert(30);
        myQueue.insert(30);
        myQueue.insert(30);
        myQueue.view();
        
    }
}