import java.util.*;
 
public class Main {
    public static int[] largestSubarraySumK(int[] nums, int k) {
        int maxLen = 0;
        int[] result = {-1, -1};
 
        for (int i = 0; i < nums.length; ++i) {
            int currentSum = 0;
            for (int j = i; j < nums.length; ++j) {
                currentSum += nums[j];
                if (currentSum == k && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    result[0] = i + 1;  // 1-based index
                    result[1] = j + 1;
                }
            }
        }
        return result;
    }
 
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, -1, 6};
        int k = 9;
        int[] result = largestSubarraySumK(nums, k);
        if (result[0] != -1) {
            System.out.println("Largest subarray with sum " + k + " is from index " + result[0] + " to " + result[1]);
        } else {
            System.out.println("No subarray with sum " + k);
        }
    }
}
