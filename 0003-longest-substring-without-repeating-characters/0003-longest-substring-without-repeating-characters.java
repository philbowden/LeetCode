class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();

        while(j < n) {
            char current = s.charAt(j);
            
            while(set.contains(current)) {
                char left = s.charAt(i++);
                set.remove(left);
            }
            set.add(current);
            max = Math.max(max, set.size());
            ++j;
            
        }
        return max;
    }
}
