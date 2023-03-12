public class TCS_RunLengthEncoding {
  public static void main(String[] args) {
    String s = "AAAAAAAAAAAAAAAAAAAAABBCCCCDD";
    // int[] count = new int[s.length()];
    // for (int i = 0; i < s.length(); i++) {
    // count[i] = 0;
    // }
    int count = 1;
    String output = " ";
    for (int i = 0; i < s.length(); i++) {
      count = 1;
      while ((i + 1) < s.length() && s.charAt(i) == s.charAt(i + 1)) {
        count++;
        i++;
      }
      int temp = count % 9;
      if (count < 9 && temp != 0)
        output = output + String.valueOf(count) + s.charAt(i);
      else {
        while (count > 0) {
          output = output + '9' + s.charAt(i);
          count = count - 9;
        }
        // output = output + '9' + s.charAt(i) + String.valueOf(temp) + s.charAt(i);
      }

    }
    System.out.println(output);
  }
}