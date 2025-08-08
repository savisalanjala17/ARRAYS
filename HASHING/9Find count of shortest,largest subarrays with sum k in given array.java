import java.util.*;
 
public class Main {
 
    public static Pair<Integer, Integer> findSubarraySizes(int n, int k, int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        Map<Integer, Integer> mp2 = new HashMap<>();
        mp.put(0, 0);
        int pSum = 0;
        int maxLength = 0;
        int minLength = Integer.MAX_VALUE;
 
        for (int j = 1; j <= n; j++) {
            pSum += arr[j - 1];
            int x = pSum - k;
 
            if (mp.containsKey(x)) {
                int i = mp.get(x) + 1;
                int curLength = j - i + 1;
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
            }
 
            if (mp2.containsKey(x)) {
                int i = mp2.get(x) + 1;
                int curLength = j - i + 1;
                if (curLength < minLength) {
                    minLength = curLength;
                }
            }
 
            mp.putIfAbsent(pSum, j);
            mp2.put(pSum, j);
        }
 
        return new Pair<>(maxLength, minLength);
    }
 
    public static int countSubarraysWithLength(int n, int k, int[] arr, int targetLength) {
        if (targetLength == 0) return 0;
        int count = 0;
        int windowSum = 0;
 
        for (int j = 0; j < targetLength; j++) {
            windowSum += arr[j];
        }
 
        if (windowSum == k) {
            count++;
        }
 
        for (int j = targetLength; j < n; j++) {
            windowSum += arr[j] - arr[j - targetLength];
            if (windowSum == k) {
                count++;
            }
        }
 
        return count;
    }
 
    public static void main(String[] args) {
        int n = 6;
        int k = 5;
        int[] arr = {1, 2, 3, 4, 2, 5};
 
        Pair<Integer, Integer> sizes = findSubarraySizes(n, k, arr);
        int maxLength = sizes.getKey();
        int minLength = sizes.getValue();
 
        int maxCount = countSubarraysWithLength(n, k, arr, maxLength);
        int minCount = countSubarraysWithLength(n, k, arr, minLength);
 
        System.out.println("Max Length: " + maxLength + " Count: " + maxCount);
        System.out.println("Min Length: " + minLength + " Count: " + minCount);
    }
}
 
class Pair<K, V> {
    private K key;
    private V value;
 
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
 
    public K getKey() {
        return key;
    }
 
    public V getValue() {
        return value;
    }
}




import java.util.*;
 
public class Main {
 
    public static int countShortestSubarraysWithSumK(int[] nums, int k) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE, count = 0;
 
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += nums[end];
                if (sum == k) {
                    int length = end - start + 1;
                    if (length < minLength) {
                        minLength = length;
                        count = 1;
                    } else if (length == minLength) {
                        count++;
                    }
                }
            }
        }
 
        return count;
    }
 
    public static int countLargestSubarraysWithSumK(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0, count = 0;
 
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += nums[end];
                if (sum == k) {
                    int length = end - start + 1;
                    if (length > maxLength) {
                        maxLength = length;
                        count = 1;
                    } else if (length == maxLength) {
                        count++;
                    }
                }
            }
        }
 
        return count;
    }
 
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 2, 5};
        int k = 5;
 
        System.out.println("Shortest subarrays with sum " + k + ": " + countShortestSubarraysWithSumK(nums, k));
        System.out.println("Largest subarrays with sum " + k + ": " + countLargestSubarraysWithSumK(nums, k));
    }
}
 
