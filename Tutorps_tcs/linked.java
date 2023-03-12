import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node() {
        next = null;
    }
}

class linked {
    public Node rearrange(Node head, int val) {
        if (head == null || head.next == null) {
            return head;
        }

        Node lessvaluestart, lessvaluened, equalvaluestart, equalvalueend, greatervaluestart, greatervalueend;
        lessvaluened = lessvaluestart = null;
        equalvaluestart = equalvalueend = null;
        greatervalueend = greatervaluestart = null;

        Node node = head;

        while (node != null) {
            if (node.data < val) {
                if (lessvaluestart == null) {
                    lessvaluestart = lessvaluened = node;
                } else {
                    lessvaluened.next = node;
                    lessvaluened = node;
                }
            } else if (node.data == val) {
                if (equalvaluestart == null) {
                    equalvaluestart = equalvalueend = node;
                } else {
                    equalvalueend.next = node;
                    equalvalueend = node;
                }
            } else if (node.data > val) {
                if (greatervaluestart == null) {
                    greatervaluestart = greatervalueend = node;
                } else {
                    greatervalueend.next = node;
                    greatervalueend = node;
                }
            }
            node = node.next;
        }
        lessvaluened.next = equalvaluestart;
        equalvalueend.next = greatervaluestart;
        greatervalueend = null;

        return lessvaluestart;
    }

    public Node addnewnode(int value) {
        Node n = new Node();
        n.data = value;
        n.next = null;
        return n;
    }

    public Node insert(int key, Node n) {

        if (n == null)
            return addnewnode(key);
        else
            n.next = insert(key, n.next);

        return n;
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
        Scanner sc = new Scanner(System.in);
        linked a = new linked();
        Node head = null;

        head = a.insert(3, head);
        head = a.insert(0, head);
        head = a.insert(5, head);
        head = a.insert(2, head);
        head = a.insert(1, head);
        head = a.insert(4, head);

        head = a.rearrange(head, 3);
        a.displaylist(head);
        sc.close();
    }
}

// 0-->2-->1-->3-->5-->4
