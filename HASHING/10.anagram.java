public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> a = new HashMap<>();
        Map<Character, Integer> b = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            a.put(s.charAt(i), a.getOrDefault(s.charAt(i), 0) + 1);
            b.put(t.charAt(i), b.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (!a.getOrDefault(c, 0).equals(b.getOrDefault(c, 0))) {
                return false;
            }
        }

        return true;
    }
}


class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> counts = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
            counts.put(t.charAt(i), counts.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (int count : counts.values()) {
            if (count != 0) return false;
        }

        return true;
    }
}
