import java.util.Scanner;

public class Cipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String cipher = sc.next();
        StringBuffer res = new StringBuffer();
        int key = sc.nextInt();

        for (int i = 0; i < cipher.length(); i++) {
            char ch = (char) (((int) cipher.charAt(i) + key - 97) % 26 + 97);
            System.out.print(ch);
        }
        System.out.println();
        sc.close();

    }
}