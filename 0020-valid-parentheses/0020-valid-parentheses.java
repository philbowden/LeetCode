class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() < 2) {
            return false;
        }
        Map<Character, Character> m = new HashMap<>();
        m.put(')', '(');
        m.put(']', '[');
        m.put('}', '{');
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (m.containsKey(currentChar)) {
                Character charFromStack = ' ';
                if (!stack.isEmpty()) {
                    charFromStack = stack.pop();
                } else {
                    return false;
                }
                if (charFromStack != m.get(currentChar)) {
                    return false;
                }
            } else {
                stack.push(currentChar);
            }
        }
        return stack.isEmpty();
    }
}