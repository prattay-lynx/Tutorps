/*
 * Given a string representation of the first n digits of Pi and a list of
 * positive integers (all in string format), write a function that returns the
 * smallest number of spaces that can be added to the n digits of Pi such that
 * all resulting numbers are found in the list of integers.
 * 
 * Note that a single number can appear multiple times in the resulting numbers.
 * For example, if Pi is "3141" and the numbers are ["1", "3", "4"], the number
 * "1" is allowed to appear twice in the list of resulting numbers after three
 * spaces are added: "3 | 1 | 4 | 1".
 * 
 * If no number of spaces to be added exists such that all resulting numbers are
 * found in the list of integers, the function should return -1.
 * 
 * Input format
 * NOT APPLICABLE
 * 
 * Output format
 * NOT APPLICABLE
 * 
 * Constraints
 * NOT APPLICABLE
 * 
 * Sample input
 * pi = "3141592653589793238462643383279",
 * numbers = ["314159265358979323846", "26433", "8", "3279", "314159265",
 * "35897932384626433832", "79"]
 * Sample output
 * 2 // "314159265 | 35897932384626433832 | 79"
 */

import java.util.*;

public class Pi {

    public static int numbersInPi(String pi, String[] numbers) {
        Set<String> numbersSet = new HashSet<>(Arrays.asList(numbers));
        Map<Integer, Integer> cache = new HashMap<>();
        int minSpaces = numbersInPi(pi, numbersSet, cache, 0);
        return minSpaces == Integer.MAX_VALUE ? -1 : minSpaces;
    }

    public static int numbersInPi(String pi, Set<String> numbersSet, Map<Integer, Integer> cache, int idx) {
        if (idx == pi.length()) {
            return -1;
        }
        if (cache.containsKey(idx)) {
            return cache.get(idx);
        }
        int minSpaces = Integer.MAX_VALUE;
        for (int i = idx; i < pi.length(); i++) {
            String prefix = pi.substring(idx, i + 1);
            if (numbersSet.contains(prefix)) {
                int spaces = numbersInPi(pi, numbersSet, cache, i + 1);
                if (spaces != Integer.MAX_VALUE) {
                    minSpaces = Math.min(minSpaces, spaces + 1);
                }
            }
        }
        cache.put(idx, minSpaces);
        return minSpaces;
    }

    public static void main(String[] args) {
        String pi = "3141592653589793238462643383279";
        String[] numbers = { "314159265358979323846", "26433", "8", "3279", "314159265", "35897932384626433832", "79" };
        int minSpaces = numbersInPi(pi, numbers);
        System.out.println(minSpaces); // Output: 2
    }
}
