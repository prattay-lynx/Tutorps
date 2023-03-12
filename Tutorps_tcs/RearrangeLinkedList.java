import java.util.*;

public class RearrangeLinkedList {

    public static LinkedList<Integer> rearrange(LinkedList<Integer> initial, int k) {
        LinkedList<Integer> less = new LinkedList<>();
        LinkedList<Integer> more = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        for (int j = 0; j < initial.size(); j++) {
            if (initial.get(j) < k) {
                less.add(initial.get(j));
            } else {
                more.add(initial.get(j));
            }
        }
        res.addAll(less);
        res.addAll(more);
        return res;

    }

    public static void main(String[] args) {
        LinkedList<Integer> initial = new LinkedList<>();

        initial.add(3);
        initial.add(0);
        initial.add(5);
        initial.add(4);
        initial.add(2);

        int k = 3;
        LinkedList<Integer> res = rearrange(initial, k);

        System.out.print(res.get(0));
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) != null)
                System.out.print("-->");
            System.out.print(res.get(i));
        }
    }
}
