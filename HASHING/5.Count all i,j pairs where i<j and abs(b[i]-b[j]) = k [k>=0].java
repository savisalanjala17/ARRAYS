import java.util.HashMap;
 
public class Main {
    public static int countPairsWithDifferenceK(int[] b, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;
 
        for (int j = 0; j < b.length; ++j) {
            if (freq.containsKey(b[j] - k)) {
                count += freq.get(b[j] - k);
            }
            if (k != 0 && freq.containsKey(b[j] + k)) { // to avoid double counting when k = 0
                count += freq.get(b[j] + k);
            }
 
            freq.put(b[j], freq.getOrDefault(b[j], 0) + 1);
        }
 
        return count;
    }
 
    public static void main(String[] args) {
        int[] b = {1, 5, 3, 4, 2};
        int k = 2;
        System.out.println(countPairsWithDifferenceK(b, k)); // Output should be the number of pairs with difference k
    }
}






import java.util.*;
 
public class Main {
 
    public static int countPairs(int[] b, int k) {
        int count = 0;
        int n = b.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i+1; j < n; ++j) {
                if (Math.abs(b[i] - b[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }
 
    public static void main(String[] args) {
        int[] b = {1, 7, 5, 9, 2, 12, 3};
        int k = 2;
        System.out.println("Number of pairs: " + countPairs(b, k));
    }
}
