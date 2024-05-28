class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) stack.push(map.get(cur));
            else {
                if (stack.isEmpty()) return false;
                else if (!stack.isEmpty() && stack.peek() != cur) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }
}