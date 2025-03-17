class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c, 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            else map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) map.remove(c);
        }
        return true;
    }
}