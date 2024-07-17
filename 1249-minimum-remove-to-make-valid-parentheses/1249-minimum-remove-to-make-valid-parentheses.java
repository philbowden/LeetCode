class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int opens = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                sb.append(c);
                opens++;
            } else if (c == ')' && opens > 0) {
                sb.append(c);
                opens--;
            } else if (c != ')') {
                sb.append(c);
            }
        }
        if (opens > 0) {
            for (int i = sb.length()-1; i >= 0; i--) {
                char c = sb.charAt(i);
                if (c == '(' && opens > 0) {
                    sb.deleteCharAt(i);
                    opens--;
                }
            }
        }
        return sb.toString();
    }
}