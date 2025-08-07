import java.util.*;

public class Main {
    public static boolean containsNearbyDuplicateOptimized(int[] nums, int k) {
        Map<Integer, Integer> numIndices = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (numIndices.containsKey(nums[i]) && i - numIndices.get(nums[i]) <= k) {
                return true;
            }
            numIndices.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 1, 2, 3};
        int k = 2;
        if (containsNearbyDuplicateOptimized(nums, k)) {
            System.out.println("There are two equal numbers within distance " + k);
        } else {
            System.out.println("No two equal numbers found within distance " + k);
        }
    }
}





import java.util.*;

public class Main {
    public static boolean containsNearbyDuplicateBruteForce(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n && j <= i + k; ++j) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 1, 2, 3};
        int k = 2;
        if (containsNearbyDuplicateBruteForce(nums, k)) {
            System.out.println("There are two equal numbers within distance " + k);
        } else {
            System.out.println("No two equal numbers found within distance " + k);
        }
    }
}
