class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            char[] characters = str.toCharArray();
            Arrays.sort(characters);
            StringBuilder s = new StringBuilder();
            for (char c : characters) {
                s.append(c);
            }
            String key = s.toString();
            if (!map.containsKey(s.toString())) map.put(key, new ArrayList<>());
            List<String> list = map.get(key);
            list.add(str);
            map.put(key, list);
        }
        for (List<String> value : map.values()) {
            res.add(value);
        }
        return res;
    }
}