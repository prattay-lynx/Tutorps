public class Repeating {
    public static int findFirstNonRepeatingChar(String s) {
        int[] Count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            Count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (Count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "abcdcaf";
        int index = findFirstNonRepeatingChar(s);
        System.out.println(index);
    }
}
