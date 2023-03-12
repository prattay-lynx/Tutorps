import java.util.Scanner;

public class Toggle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char str1[] = str.toCharArray();

        // char ar [] = str1.toCharArray();

        for (int i = 0; i < str1.length; i++) {
            if (str1[i] >= 'a' && str1[i] <= 'z')
                str1[i] = (char) (str1[i] + 'A' - 'a');
            else if (str1[i] >= 'A' && str1[i] <= 'Z')
                str1[i] = (char) (str1[i] + 'a' - 'A');
        }

        System.out.println(str1);
        sc.close();

        // List<String> str = new ArrayList<String>();
    }
}
