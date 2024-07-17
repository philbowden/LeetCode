class Solution {
public String minRemoveToMakeValid(String s) {
        int opens = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                opens++;
                sb.append(c);
            }
            else if (c == ')' && opens > 0) {
                sb.append(c);
                opens--;
            }
            else if (c != ')') sb.append(c);
        }
        if (opens > 0) {
            for (int i = sb.length() - 1; i >= 0; i--) {
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
