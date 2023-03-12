import java.util.*;

public class Document {
    public static boolean checkDocument(String characters, String document) {
        characters = characters.replaceAll("\\s", "");
        document = document.replaceAll("\\s", "");
        char arr1[] = characters.toCharArray();
        Arrays.sort(arr1);
        System.out.println(arr1);
        char arr2[] = document.toCharArray();
        Arrays.sort(arr2);
        boolean flag = false;
        System.out.println(arr2);
        if (arr1.length <= arr2.length)
            System.exit(0);

        for (int i = 0; i < arr2.length; i++) {
            if (arr1[i] == arr2[i]) {
                flag = true;
            } else {
                flag = false;
                break;
            }

        }
        return flag;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        String characters = sc.next();
        String document = sc.next();
        // characters += sc.nextLine();
        // document += sc.nextLine();

        boolean res = checkDocument(characters, document);
        System.out.println(res);
    }
}