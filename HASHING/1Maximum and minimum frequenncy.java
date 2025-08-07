import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {1, 1, 2, 3, 3, 3};

        Map<Integer, Integer> mp = new HashMap<>();
        int maxiFreq = Integer.MIN_VALUE, maxiElement = arr[0];
        int miniFreq = Integer.MAX_VALUE, miniElement = arr[0];

        for (int i = 0; i < arr.length; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> num : mp.entrySet()){
            if (num.getValue() >= maxiFreq){
                maxiFreq = num.getValue();
                maxiElement = num.getKey();
            }
            if (num.getValue() <= miniFreq){
                miniFreq = num.getValue();
                miniElement = num.getKey();
            }
        }

        

        System.out.println("Max frequency element: " + maxiElement + " with frequency: " + maxiFreq);
        System.out.println("Min frequency element: " + miniElement + " with frequency: " + miniFreq);
    }
}







import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int maxElement = 0, maxCount = 0, minElement = 0, minCount = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    cnt++;
                }
            }
            
            if (maxCount < cnt) {
                maxCount = cnt;
                maxElement = arr[i];
            }
            
            if (minCount > cnt) {
                minCount = cnt;
                minElement = arr[i];
            }
        }
        
        System.out.println("Max Element: " + maxElement + ", Max Count: " + maxCount);
        System.out.println("Min Element: " + minElement + ", Min Count: " + minCount);
    }
}
