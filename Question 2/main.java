class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class Main {
    Node node;
    Node prevNode = null;
    Node headNode = null;

    // Function to perform in-order traversal and to convert the BST into a skewed tree
    void toSkew(Node root) {
        if(root == null)
            return;

        toSkew(root.left);

        Node rightNode = root.right;

        // Condition to check if the node is the head node
        if(headNode == null) {
            headNode = root;
            root.left = null;
            prevNode = root;
        } else {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }

        toSkew(rightNode);
    }

    // Function to traverse the right skewed tree
    void traverse(Node root) {
        if(root == null)
            return;

        System.out.print(root.data + " ");
        traverse(root.right);
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left = new Node(55);

        tree.toSkew(tree.node);
        tree.traverse(tree.headNode);
    }
}
