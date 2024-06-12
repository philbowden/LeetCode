class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while(j < n) {
            while(!set.add(s.charAt(j))) set.remove(s.charAt(i++));
            max = Math.max(max, j - i + 1);
            ++j;
        }
        return max;
    }
}
/**
set [cb]
max 3
abcabcbb
     i 
       j

 */