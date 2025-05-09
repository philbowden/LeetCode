class Solution {
public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
                String key = makeKey(s);
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>(Arrays.asList(s)));
                } else {
                    map.get(key).add(s);
                }
            }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    private String makeKey(String s) {
        StringBuilder sb = new StringBuilder();
        char[] array = s.toCharArray();
        Arrays.sort(array);
        for (char c : array) {
            sb.append(c);
        }
        return sb.toString();
    }
    
}