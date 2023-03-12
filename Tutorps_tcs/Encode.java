import java.util.Scanner;

public class Encode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.next();
        text = text.toUpperCase();

        StringBuffer res = new StringBuffer("");

        char c = text.charAt(0); // initializing the character at the first pos to c
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            // count = 1;
            if (text.charAt(i) != c) { // if the current letter not equal to the character ait i
                res.append(count + "" + c); // normally add it to res
                c = text.charAt(i); // set the current character to i
                count = 1; // count again initialized to 1
                // count++;
            } else {
                if (count >= 9) {
                    res.append('9' + "" + c);
                    count = 0;
                }
                count++;
            }
        }
        res.append(count + "" + c);
        System.out.println(res);
        sc.close();
    }
}
