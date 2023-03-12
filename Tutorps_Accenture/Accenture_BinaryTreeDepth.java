
class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Accenture_BinaryTreeDepth {
    public static void create(Node root) {
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
    }

    public static int depthTree(Node root, int depth) {

        if (root == null) {
            return 0;
        }
        // if (root.left != null)
        // return depthTree(root.left, depth + 1, value);
        // if (root.right != null)
        // return depthTree(root.right, depth + 1, value);
        return (depth + depthTree(root.left, depth + 1) + depthTree(root.right, depth + 1));
    }

    // public static void display(Node node) {
    // if (node != null) {
    // System.out.print(node.data + " ");
    // display(node.left);
    // display(node.right);
    // }
    // }
    public static void main(String[] args) {
        Node root = new Node(1);
        create(root);
        // display(root);
        // System.out.println();
        int h = depthTree(root, 0);
        System.out.println(h);
    }
}