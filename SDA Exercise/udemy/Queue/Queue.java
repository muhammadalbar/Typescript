public class Queue{
    private int maxSize; // max number of slots
    private long[] queArray; // slots to maintain the data
    private int front; // index position for the element in the front
    private int rear; // index position for the element in the bac
    private int items; // counter number of items in queue

    public Queue(int size){
        this.maxSize = size;
        this.queArray = new long[maxSize];
        front = 0;
        rear = -1;
        items = 0;
    }

    public void insert(long j){
        if(rear == maxSize -1){
            rear = -1;
        }
        else{
            rear++;
            queArray[rear] = j;
            items++;
        }
        
    }

    public long remove(){
        long temp = queArray[front];
        front++;
        if(front == maxSize){
            front = 0;
        }
        items--;
        return temp;
    }

    public long peekFront(){
        return queArray[front];
    }

    public boolean isEmpty(){
        return (items == 0);
    }

    public boolean isFull(){
        return (items == maxSize);
    }

    public void view(){
        System.out.print("[ ");
        for(int i = 0; i < queArray.length; i++){
            System.out.print(queArray[i] + " ");
        }
        System.out.print("]");
    }
}