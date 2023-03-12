import java.util.*;

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

public class Accenture_BinaryTree {
    public static void create(Node root) {
        Scanner sc = new Scanner(System.in);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        root.left.right.left = new Node(10);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
    }

    // public static void display(Node node) {
    // if (node != null) {
    // System.out.print(node.data + " ");
    // display(node.left);
    // display(node.right);
    // }
    // }

    public static ArrayList<Integer> branchSum(Node root) {
        ArrayList<Integer> sumlist = new ArrayList<>();
        return branchSum(root, 0, sumlist);
    }

    public static ArrayList<Integer> branchSum(Node root, int sum, ArrayList<Integer> sumlist) {
        if (root == null)
            return sumlist;

        sum += root.data;
        if (root.left == null && root.right == null)
            sumlist.add(sum);
        if (root.left != null)
            branchSum(root.left, sum, sumlist);
        if (root.right != null)
            branchSum(root.right, sum, sumlist);
        return sumlist;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        create(root);
        // display(root);
        // System.out.println();
        ArrayList<Integer> sum = branchSum(root);
        System.out.println(sum);
    }

}