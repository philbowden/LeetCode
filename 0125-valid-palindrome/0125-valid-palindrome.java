class Solution {
    public boolean isPalindrome(String s) {
  
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                sb.append(c);
            }
        }
        String input = sb.toString();
        input = input.toLowerCase();
        int left = 0, right = input.length()-1;
        while(left < right) {
            if (input.charAt(left) != input.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}