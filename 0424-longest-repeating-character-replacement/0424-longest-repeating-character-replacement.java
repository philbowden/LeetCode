class Solution {
public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int maxLength = 0, maxCount = 0;
        int i = 0, j = 0;

        while(j < n) {
            char current = s.charAt(j);
            map.put(current, map.getOrDefault(current, 0) + 1);
            int currentCount = map.get(current);
            maxCount = Math.max(maxCount, currentCount);

            while(j - i - maxCount + 1 > k) {
                char start = s.charAt(i++);
                map.put(start, map.get(start) - 1);
            }

            maxLength = Math.max(maxLength, j - i + 1);
            ++j;
        }

        return maxLength;
    }
}