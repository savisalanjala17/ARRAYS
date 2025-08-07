import java.util.*;
 
public class Main {
    static int countPairsWithSum(int[] b, int k) {
        int count = 0;
        Map<Integer, Integer> seen = new HashMap<>();
 
        for (int j = 0; j < b.length; ++j) {
            int complement = k - b[j];
            if (seen.containsKey(complement)) {
                count++;
            }
            seen.put(b[j], j);
        }
 
        return count;
    }
 
    public static void main(String[] args) {
        int[] b = {1, 2, 3, 4, 5};
        int k = 6;
        int count = countPairsWithSum(b, k);
 
        System.out.println("Count of pairs with sum " + k + " is: " + count);
    }
}





import java.util.*;
 
public class Main {
    public static int bruteForceCountPairs(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[i] + arr[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }
 
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 6;
        System.out.println("Count of pairs: " + bruteForceCountPairs(arr, k));
    }
}
 
