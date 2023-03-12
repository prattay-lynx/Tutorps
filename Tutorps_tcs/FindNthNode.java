
import java.util.*;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class FindNthNode extends Exception { // find nth node from last

    public static void NthNodeFromLast(Node head, int n) {
        int count = 1;
        Node ptr = head;

        while (ptr.next != null) {
            count++;
            ptr = ptr.next;
        }
        int node_from_first = count - n;
        int k = 1;
        ptr = head;
        while (k <= node_from_first) {
            k++;
            ptr = ptr.next;
        }
        System.out.println("The data part of the nth node from last:" + ptr.data);
    }

    public String toString() {
        return "Fuck Yourself";
    }

    public Node insert(Scanner sc, Node head) {
        // Node head = null;
        int ask = 0;
        do {
            System.out.print("Enter the fucking value of the node:");
            int data = sc.nextInt();
            Node newNode = new Node(data);
            System.out.println();
            if (head == null) {
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }

            System.out.print("want to continue press:1 else 0:");
            ask = sc.nextInt();
        } while (ask != 0);
        return head;

    }

    public void displaylist(Node start) {

        while (start != null) {
            System.out.print(start.data);
            if (start.next != null)
                System.out.print("-->");
            start = start.next;
        }
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            FindNthNode a = new FindNthNode();
            Node head = null;
            head = a.insert(sc, head);

            // head = a.rearrange(head, 3);
            a.displaylist(head);
            System.out.println("\nEnter the nth node from end you want to see bitch:");
            int n = sc.nextInt();

            NthNodeFromLast(head, n);
            sc.close();
        } catch (InputMismatchException e) {
            System.out.println(e.toString());
        }

    }
}
/*
 * Enter the fucking value of the node:4
 * 
 * want to continue press:1 else 0:
 * 1
 * Enter the fucking value of the node:4
 * 
 * want to continue press:1 else 0:1
 * Enter the fucking value of the node:4
 * 
 * want to continue press:1 else 0:1
 * Enter the fucking value of the node:4
 * 
 * want to continue press:1 else 0:1
 * Enter the fucking value of the node:6
 * 
 * want to continue press:1 else 0:1
 * Enter the fucking value of the node:7
 * 
 * want to continue press:1 else 0:1
 * Enter the fucking value of the node:98
 * 
 * want to continue press:1 else 0:0
 * 98-->7-->6-->4-->4-->4-->4
 * Enter the nth node from end you want to see bitch:
 * 5
 * The data part of the nth node from last:6
 */