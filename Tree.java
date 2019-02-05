public class Tree {
    
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(args[0], args[1]);
        bt.Print();
    }


    public static class Node {
        private char data;
        public Node left, right;
  
        public char GetData() { return data; }
  
        public Node(char data) {
        this.data = data;
        }
    }

    public static class BinaryTree {
        private Node root;
        private String preOrder, inOrder;
        private int preOrderIdx;
  
        public BinaryTree(String preOrder, String inOrder) {
            this.preOrder = preOrder;
            this.inOrder = inOrder;
            this.preOrderIdx = -1;
    
            root = FindRoot(0, inOrder.length() - 1);
        }
        
        // recursive printing function
        public void Print() {
            Print(root);
        }
        
        // print function
        private void Print(Node node) {
            if (node == null) return;
    
            System.out.print("Node " + node.GetData() + ": ");
            if (node.left != null)
                System.out.print(" Left " + node.left.GetData());
            if (node.right != null)
                System.out.print(" Right " + node.right.GetData());
            System.out.println();
    
            Print(node.left);
            Print(node.right);
        }
  
        private Node FindRoot(int inOrderLeft, int inOrderRight) { //arguments are the limits of the interval searched
            if (inOrderLeft > inOrderRight) return null;
            
            // each node from preOrder is considered to be the root, one by one
            Node root = new Node(preOrder.charAt(++preOrderIdx)); // string.charAt(int) --> method that returns the char that can be found on position (int) in a string
            if (inOrderLeft == inOrderRight) return root;
    
            int rootIdx = -1;
            // searching for the root from preOrder in inOrder
            for (int i = inOrderLeft; rootIdx == -1 && i <= inOrderRight; ++i)
                if (inOrder.charAt(i) == root.GetData())
                    rootIdx = i;
            // recursive call of the function to generate the initial tree
            root.left = FindRoot(inOrderLeft, rootIdx - 1);
            root.right = FindRoot(rootIdx + 1, inOrderRight);
            return root;
        }
    }
}
// complexity is O(n^2) --> Gary will ask this for sure :))
// why O(n^2)? Worst case: preOrder ABCDE inOrder: EDCBA --> we have to go through the entire string to find A in inOrder, then again for B which is right before A in inOrder and so on.