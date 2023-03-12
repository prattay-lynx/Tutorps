import java.util.*;

public class NonRepeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int count = 0, place = 0;
        String str = sc.next();
        char ar[] = str.toCharArray();
        for (int i = 0; i < ar.length - 1; i++) {
            for (int j = 0; j < ar.length; j++) {
                if (ar[i] == ar[j]) {
                    count++;
                }
                if (count == 0) {
                    place = i;
                    break;
                }
            }

        }
        System.out.println(ar[place]);
    }
}
