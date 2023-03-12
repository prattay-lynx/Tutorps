class Node {
    int data;
    Node next;

    // public Node(int data) {
    // this.data = data;
    // this.next = null;
    // }

    public Node() {
        next = null;
    }
}

public class FindLoop {
    // public static Node head = null;
    // public static Node tail = null;
    public static Node joint = null;

    public Node beginLoopPtr(Node head) {
        Node fastptr = head;
        Node slowptr = head;
        int loopexist = 0;
        while (slowptr != null && fastptr != null && fastptr.next != null) {
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
            if (slowptr == fastptr) {
                loopexist = 1;
                break;
            }
        }
        if (loopexist == 1) {
            slowptr = head;
            while (slowptr != fastptr) {
                fastptr = fastptr.next;
                slowptr = slowptr.next;
            }
            return slowptr;
        }
        return null;
    }

    public static Node create(int data, Node head) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
        return head;
    }

    public static Node loop(Node head, int loop_point) {
        Node temp = head;
        int count = 1;
        while (count < loop_point) {
            temp = temp.next;
            count++;
        }

        joint = temp;

        while (temp.next != null)
            temp = temp.next;

        temp.next = joint;
        return head;
    }

    public void displaylist(Node head) {
        int count = 0;
        Node start = head;
        while (count < 10) {
            count++;
            System.out.print(start.data + "-->");
            // if (start.next != head)
            // System.out.print("-->");
            start = start.next;
        }
        System.out.print(joint.data);
    }

    public static void main(String[] args) {
        FindLoop a = new FindLoop();
        Node head = null;
        head = create(9, head);
        head = create(8, head);
        head = create(7, head);
        head = create(6, head);
        head = create(5, head);
        head = create(4, head);
        head = create(3, head);
        head = create(2, head);
        head = create(1, head);
        head = create(0, head);

        int loop_point = 5; // count is starting from 1

        head = loop(head, loop_point);

        System.out.println("The initial linked list:");
        a.displaylist(head);
        System.out.println();
        Node ref = a.beginLoopPtr(head);
        System.out.println(ref.data);
    }
}
