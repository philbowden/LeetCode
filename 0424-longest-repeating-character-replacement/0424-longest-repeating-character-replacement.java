class Solution {
public int characterReplacement(String s, int k) {
        int[] charCounts = new int[26];
        int n = s.length();
        int maxLength = 0, maxCount = 0;
        int i = 0, j = 0;

        while(j < n) {
            char current = s.charAt(j);
            charCounts[current - 'A']++;
            int currentCount = charCounts[current-'A'];
            maxCount = Math.max(maxCount, currentCount);

            while(j - i - maxCount + 1 > k) {
                charCounts[s.charAt(i++) - 'A']--;
            }

            maxLength = Math.max(maxLength, j - i + 1);
            ++j;
        }

        return maxLength;
    }
}