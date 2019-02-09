public class DoublyLinkedList{
    private Node first;
    private Node last;

    public DoublyLinkedList(){
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;
        if(isEmpty()){
            last = newNode; // if empty last will refer to the new node being created
        }
        else{
            first.prev = newNode;
        }
        newNode.next = first; // will be point to the old first
        this.first = newNode; 
    }

    public void insertLast(int data){
        Node newNode = new Node();
        newNode.data = data;
        if(isEmpty()){
            first = newNode; // if empty first will refer to the new node being created
        }
        else{
            last.next = newNode;
        }
        newNode.prev = last; // will be point to old last
        this.last = newNode;
    }

    public Node deleteFirst(){
        Node temp = first;
        if(first.next == null){ // there is only one item in the list
            last = null;
        }
        else{
            first.next.prev = null;
        }
        first = first.next; // first will be the next of the old first
        return temp; // return the deleted old first
    }

    public Node deleteLast(){
        Node temp = last;
        if(last.prev == null){ // there is only one item in the list
            first = null;
        }
        else{
            last.prev.next = null;
        }
        last = last.prev; // last will be the prev of the old last
        return temp;
    }

    // insert in the position that we want, the key is gonna be the data in the list,
    // the data will be the node that we want to insert after
    public boolean insertAfter(int key, int data){ 
        Node current = first;
        // as long as we have not found the key in a particular node
        while(current.data != key){
            current = current.next;
            if(current == null){
                return false;
            }
        }
        Node newNode = new Node();
        newNode.data = data;

        if(current == last){
            current.next = null;
        } 
        else{
            newNode.next = current.next;
            current.next.prev = newNode;
        }
        newNode.prev = current;
        current.next = newNode;
        return true; 
    }

    public Node deleteKey(int key){
        Node current = first;
        while(current.data != key){
            current = current.next;
            if(current == null){
                return null;
            }
        }
        if(current == first){
            first = current.next; // make the first to become the next of the old first
        }
        else{
            current.prev.next = current.next;
        }
        if(current == last){
            last = current.prev; 
        }
        else{
            current.next.prev = current.prev;
        }
        return current; 
    }

    public void displayForward(){
        System.out.println("List first --> last :");
        Node current = first; // start from the beginning
        while(current != null){
            current.displayNode(); // call the display method
            current = current.next; // move to the next node
        }
        System.out.println();
    }

    public void displayBackward(){
        System.out.println("List last --> first");
        Node current = last; // start from the last
        while(current != null){
            current.displayNode();
            current = current.prev;
        }
        System.out.println();
    }
}