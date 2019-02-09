public class BST{
    private Node root;

    public void insert(int key, String value){
        Node newNode = new Node(key, value);
        if(root == null){
            root = newNode;
        }
        else{
            Node current = root;
            Node parent; 
            while(true){
                parent = current;
                if(key < current.key){
                    current = current.left;
                    if(current == null){
                        parent.left = newNode;
                        return;
                    }
                }
                else{
                    current = current.right;
                    if(current == null){
                        parent.right = newNode;
                        return;  
                    }
                }
            }
        }
    }

        public Node findMin(){
            Node current = root;
            Node last = null;
            while(current != null){
                last = current;
                current = current.left;    
            }
            return last;
        }

        public Node findMax(){
            Node current = root;
            Node last = null;
            while(current != null){
                last = current;
                current = current.right;
            }
            return last;
        }

        public boolean remove(int key){
            Node current = root;
            Node parent = root;

            boolean isLeft = false;

            // Searching to find the node with the key to delete
            while(current.key != key){
                parent = current;
                if(key < current.key){
                    isLeft = true;
                    current = current.left;
                }
                else{
                    current = current.right;
                    isLeft = false;
                }
                if(current == null){
                    return false;
                }
            }
            // found the node
            Node nodeToDelete = current;


            // if node is a leaf
            if(nodeToDelete.left == null && nodeToDelete.right == null){
                if(nodeToDelete == root){
                    root = null;
                }
                else if(isLeft){
                    parent.left = null;
                }
                else{
                    parent.right = null;
                }
            }
            // if node has one child that is on the left
            else if(nodeToDelete.right == null){
                if(nodeToDelete == root){
                    root = nodeToDelete.left;
                }
                else if(isLeft){
                   parent.left = nodeToDelete.left; 
                }
                else{
                    parent.right = nodeToDelete.left;
                }
            }
            // if node has one child that is on the right
            else if(nodeToDelete.left == null){
                if(nodeToDelete == root){
                    root = nodeToDelete.right;
                }
                else if(isLeft){
                   parent.left = nodeToDelete.right; 
                }
                else{
                    parent.right = nodeToDelete.right;
                }
            }
            // if node has two children
            else{
                Node successor = getSuccessor(nodeToDelete);
                // connect parent of nodeToDelete to successor instead
                if(nodeToDelete == root){
                    root = successor;
                }
                else if(isLeft){
                    parent.left = successor;
                }
                else{
                    parent.right = successor;
                }
                // the swap happens
                successor.left = nodeToDelete.left;
            }
            return true;
        }
        private Node getSuccessor(Node nodeToDelete){
            Node successorParent = nodeToDelete;
            Node successor = nodeToDelete;
            
            // go to the right child
            Node current = nodeToDelete.right;
            while(current != null){ // start goig left down the tree until node has no left child
                successorParent = successor;
                successor = current;
                current = current.left;
            }
            // if the successor not a right child
            if(successor != nodeToDelete.right){
                successorParent.left = successor.right;
                successor.right = nodeToDelete.right;
            }
            return successor;
        }

        
    }
