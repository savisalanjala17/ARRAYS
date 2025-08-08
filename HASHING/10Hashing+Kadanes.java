import java.util.Scanner;
 
public class Main {
    public static int maxSubarraySum(int[] b) {
        int n = b.length - 1; // Adjust for 1-based indexing
        if (n == 0) return 0;
 
        int T = 0; // Initialize T to 0, which will store the maximum sum subarray
        int prv = 0; // Initialize prv to 0, which will store the current maximum sum subarray ending at b[i]
 
        for (int i = 1; i <= n; ++i) {
            int current = Math.max(prv + b[i], b[i]);
            current = Math.max(current, 0);
            prv = current;
            T = Math.max(T, current);
        }
 
        return T;
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        int n = scanner.nextInt();
        int[] b = new int[n + 1]; // Adjust for 1-based indexing
        for (int i = 1; i <= n; ++i) {
            b[i] = scanner.nextInt();
        }
 
        int result = maxSubarraySum(b);
        System.out.println("Maximum subarray sum is " + result);
    }
}



import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n+1];
        for (int i = 1; i <= n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println("Maximum sum of two non-overlapping subarrays: " + maxTwoNonOverlappingSubarraysSum(nums));
    }
 
    public static int maxTwoNonOverlappingSubarraysSum(int[] nums) {
        int n = nums.length - 1;
        if (n == 0) return 0;
 
        int[] prefixMaxSum = calculatePrefixMaxSum(nums);
        int[] suffixMaxSum = calculateSuffixMaxSum(nums);
 
        int[] maxPrefixSum = new int[n + 2];
        maxPrefixSum[1] = prefixMaxSum[1];
        for (int i = 2; i <= n; i++) {
            maxPrefixSum[i] = Math.max(maxPrefixSum[i - 1], prefixMaxSum[i]);
        }
 
        int[] maxSuffixSum = new int[n + 2];
        maxSuffixSum[n] = suffixMaxSum[n];
        for (int i = n - 1; i >= 1; i--) {
            maxSuffixSum[i] = Math.max(maxSuffixSum[i + 1], suffixMaxSum[i]);
        }
 
        int maxSum = 0;
        for (int i = 0; i <= n; i++) {
            maxSum = Math.max(maxSum, maxPrefixSum[i] + maxSuffixSum[i + 1]);
        }
 
        return maxSum;
    }
 
    public static int[] calculatePrefixMaxSum(int[] nums) {
        int n = nums.length - 1;
        int[] prefixMaxSum = new int[n + 1];
        int currentMax = nums[1];
        prefixMaxSum[1] = nums[1];
 
        for (int i = 2; i <= n; i++) {
            currentMax = Math.max(0, Math.max(nums[i], currentMax + nums[i]));
            prefixMaxSum[i] = currentMax;
        }
 
        return prefixMaxSum;
    }
 
    public static int[] calculateSuffixMaxSum(int[] nums) {
        int n = nums.length - 1;
        int[] suffixMaxSum = new int[n + 1];
        int currentMax = nums[n];
        suffixMaxSum[n] = nums[n];
 
        for (int i = n - 1; i >= 1; i--) {
            currentMax = Math.max(0, Math.max(nums[i], currentMax + nums[i]));
            suffixMaxSum[i] = currentMax;
        }
 
        return suffixMaxSum;
    }



  import java.util.Scanner;
 
public class Main {
    public static int maxSubarraySum(int[] b) {
        int n = b.length - 1; // Adjust for 1-based indexing
        if (n == 0) return 0;
 
        int[] p1 = new int[n + 1]; // p1[0] is initialized to 0 for convenience
 
        for (int i = 1; i <= n; ++i) {
            p1[i] = Math.max(Math.max(p1[i - 1] + b[i], b[i]), 0);
            System.out.println(p1[i]);
        }
 
        int maxSum = p1[1];
        for (int i = 2; i <= n; ++i) {
            if (p1[i] > maxSum) {
                maxSum = p1[i];
            }
        }
        return maxSum;
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        int n = scanner.nextInt();
        int[] b = new int[n + 1]; // Adjust for 1-based indexing
 
        for (int i = 1; i <= n; ++i) {
            b[i] = scanner.nextInt();
        }
 
        int result = maxSubarraySum(b);
        System.out.println("Maximum subarray sum is " + result);
    }
}
 
}
