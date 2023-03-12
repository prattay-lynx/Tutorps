/*
 * Write a function that takes in an array of integers and returns a boolean representing whether the array is monotonic. 
 * An array is said to be monotonic if its elements, from left to right, are entirely non-increasing or entirely 
 * non-decreasing. Non-increasing elements aren't necessarily exclusively decreasing; they simply don't increase. 
 * Similarly, non-decreasing elements aren't necessarily exclusively increasing; 
 * they simply don't decrease. Note that empty arrays and arrays of one element are monotonic.
 */
// Sample input
// array = [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]

// Sample output
// true

public class MonotonicArray {
    public static Boolean ismonotone(int[] arr) {
        int n = arr.length;
        int count = 0;
        if (n == 1) {
            return true;
        }
        for (int i = 0; i < (n - 1); i++) {
            if (arr[0] > arr[1]) {
                if (arr[i] < arr[i + 1]) {
                    count++;
                    break;
                }
            } else if (arr[0] < arr[1]) {
                if (arr[i] > arr[i + 1]) {
                    count++;
                    break;
                }
            }
        }
        if (count > 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        int[] arr = { -5, -3, -5, -1100, -1100, -1101, -1102, -9001 };
        System.out.println(ismonotone(arr));
    }
}
