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

public class Accenture_BinaryTreeClosest {
    public static void create(Node root) {
        root.left = new Node(5);
        root.right = new Node(15);

        root.left.left = new Node(2);
        root.left.right = new Node(5);

        root.left.left.left = new Node(1);

        root.right.left = new Node(13);
        root.right.right = new Node(22);

        root.right.left.right = new Node(14);
    }

    public static void display(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            display(node.left);
            display(node.right);
        }
    }

    public static int findValue(Node root, int target, int mini, int closest) {
        if (root == null)
            return 0;
        if (target == root.data) {
            closest = root.data;
        }
        if ((Math.abs(root.data - target)) < mini) {
            mini = Math.abs(root.data - target);
            closest = root.data;
        }
        if (target < root.data)
            findValue(root.left, target, mini, closest);
        else
            findValue(root.right, target, mini, closest);
        return closest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(10);
        create(root);
        int closest = -1;
        int mini = Integer.MAX_VALUE;
        int target = sc.nextInt();
        display(root);
        System.out.println();
        int h = findValue(root, target, mini, closest);
        System.out.println(h);
        sc.close();
    }
}
