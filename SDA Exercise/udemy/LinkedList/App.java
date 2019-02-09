public class App{
    public static void main(String[] args){
        Node node1 = new Node();
        node1.data = 4;
        Node node2 = new Node();
        node2.data = 3;
        Node node3 = new Node();
        node3.data = 7;
        Node node4 = new Node();
        node4.data = 8;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(listlength(node1));
        System.out.println(listlength(node2));
        
    }
        public static int listlength(Node myNode){
            int length = 0;
            Node currentNode = myNode;

            while(currentNode != null){
                length++;
                currentNode = currentNode.next;
            }
            return length;
        }
}