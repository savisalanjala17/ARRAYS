import java.util.HashMap;
import java.util.Map;
 
public class Main {
    public static int countPairsOptimized(int[] b, int k) {
        int count = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int j = 0; j < b.length; ++j) {
            int target = b[j] + k;
            if (freqMap.containsKey(target)) {
                count += freqMap.get(target);
            }
            freqMap.put(b[j], freqMap.getOrDefault(b[j], 0) + 1);
        }
        return count;
    }
 
    public static void main(String[] args) {
        int[] b = {1, 5, 3, 4, 2};
        int k = 2;
        System.out.println("Count of pairs: " + countPairsOptimized(b, k));
    }
}




public class Main {
    public static int countPairsBruteForce(int[] b, int k) {
        int count = 0;
        int n = b.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (b[i] - b[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }
 
    public static void main(String[] args) {
        int[] b = {1, 5, 3, 4, 2};
        int k = 2;
        System.out.println("Count of pairs: " + countPairsBruteForce(b, k));
    }
}



 
