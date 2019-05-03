import java.util.*;

public class Kota {
    public static void main(String args[]){
        AVLTree tree = new AVLTree();
        ArrayList arr = new ArrayList();
        Scanner input = new Scanner(System.in);
        int bagian = input.nextInt();
        int K = input.nextInt();

        if(bagian == 1){
            for(int i = 0; i < K; i++) {
                int num = input.nextInt();
                tree.root = tree.insert(tree.root, num);
            }
            int P = input.nextInt();
            for(int j = 0; j < P; j++){
                int num2 = input.nextInt();
                tree.findNeighborhood(tree.root, num2);
            }
        }
        else if(bagian == 2){
            for(int i = 0; i < K; i++){
                int num = input.nextInt();
                tree.root = tree.insert(tree.root, num);
            }
            // int P = input.nextInt();
            // for(int j = 0; j < P; j++){
            //     int num2 = input.nextInt();
            //     System.out.println(tree.findNode(tree.root, num2));

            // }
            int M = Integer.parseInt(input.nextLine());
            for(int j = 0; j < M; j++){
                String baca = input.nextLine();
                int neighbor = Integer.parseInt(baca.split(" ")[0]);
                int firstNum = Integer.parseInt(baca.split(" ")[1]);
                int secondNum = Integer.parseInt(baca.split(" ")[2]);

                for(int q = firstNum; q <= secondNum; q++){
                    tree.deleteNode(tree.root, q);
                }
                tree.findNeighborhood(tree.root, neighbor);
            }
        }
    }
}

// Java program for deletion in AVL Tree

class Node{
    int key, height;
    Node left, right;

    Node(int d)
    {
        key = d;
        height = 1;
    }
}

class AVLTree{
    Node root;

    // A utility function to get height of the tree
    int height(Node N)
    {
        if (N == null)
            return 0;
        return N.height;
    }

    // A utility function to get maximum of two integers
    int max(int a, int b)
    {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    Node rightRotate(Node y)
    {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node leftRotate(Node x)
    {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    int getBalance(Node N)
    {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    Node insert(Node node, int key)
    {
        /* 1. Perform the normal BST rotation */
        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Equal keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                height(node.right));

		/* 3. Get the balance factor of this ancestor
		node to check whether this node became
		Wunbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then
        // there are 4 cases Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key)
        {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    /* Given a non-empty binary search tree, return the
    node with minimum key value found in that tree.
    Note that the entire tree does not need to be
    searched. */
    Node minValueNode(Node node)
    {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }

    Node deleteNode(Node root, int key)
    {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;

        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (key < root.key)
            root.left = deleteNode(root.left, key);

            // If the key to be deleted is greater than the
            // root's key, then it lies in right subtree
        else if (key > root.key)
            root.right = deleteNode(root.right, key);

            // if key is same as root's key, then this is the node
            // to be deleted
        else
        {

            // node with only one child or no child
            if ((root.left == null) || (root.right == null))
            {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                // No child case
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else // One child case
                    root = temp; // Copy the contents of
                // the non-empty child
            }
            else
            {

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.key = temp.key;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.key);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // A utility function to print preorder traversal of
    // the tree. The function also prints height of every
    // node
    void preOrder(Node node)
    {
        if (node != null)
        {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    // A utility function to search a given key in BST 
    public Node search(Node root, int key) { 
        // Base Cases: root is null or key is present at root 
        if (root==null || root.key==key){
            return root; 
        }
        // val is greater than root's key 
        if (root.key > key){ 
            return search(root.left, key); 
        }
        // val is less than root's key 
        return search(root.right, key); 
    }

    public void findNeighborhood(Node root, int data){
        if(root != null && root.key == data){
            if(root.left != null){
                System.out.print(root.left.key + " ");
            }
            if(root.right != null){
                System.out.println(root.right.key + " ");
            }
            return;
        }
        if(root != null && data < root.key){
            if(root.left != null && root.left.key == data){
                if(root.left.left != null){
                    System.out.print(root.left.left.key + " ");
                }
                if(root.left.right != null){
                    System.out.print(root.left.right.key + " ");
                }
                System.out.println(root.key);
                return; 
            }
            findNeighborhood(root.left, data);
        
        }
        if(root != null && data > root.key){
            if(root.right != null && root.right.key == data){
                System.out.print(root.key + " ");
                if(root.right.left != null){
                    System.out.print(root.right.left.key + " ");
                }
                if(root.right.right != null){
                    System.out.println(root.right.right.key + " ");
                } else {System.out.println("");}
                return;
            }
            findNeighborhood(root.right, data);
    
        }
    }

    public boolean findNode(Node root, int data){
        if(root == null || root.key == data){
            return true;
        }
        if(root != null && data < root.key){
            if(root.left != null){
                return findNode(root.left, data);
            }
            return false;
        }
        return findNode(root.right, data);
    }

    public void findNeighborhood3(Node root, int data){

    }
    

    // public Node checkNode(Node node1, Node node2){
    //     if(node1 != null){
    //         return node1;
    //     }
    //     else if(node2 != null){
    //         return node2;
    //     }
    //     else{
    //         return null;
    //     }
    // }

    // public Node getParent(Node x, Node pointer){
    //     Node parentNode = pointer;
    //     if(x == pointer){
    //         return null;
    //     }
    //     else if(x == null){
    //         return null;
    //     }
    //     else if(pointer == null){
    //         return null;
    //     }
    //     else{
    //         if(parentNode.left == x || parentNode.right == x){

    //         }
    //     }
    // }

    
}


// This code has been contributed by Mayank Jaiswal

