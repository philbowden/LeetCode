class Solution {
    public String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int n = a.length();
        int m = b.length();

        if (n < m) {
            a = evenUpStrings(a, m - n);
        }
        else if (m < n) {
            b = evenUpStrings(b, n - m);
        }

        int i = a.length() - 1;
        int carry = 0;
        s.setLength(0);
        while (i >= 0) {
            int A = a.charAt(i) - '0';
            int B = b.charAt(i) - '0';
            int cur = A + B + carry;

            s.append(cur % 2);

            carry = cur / 2;
            i--;
        }
        if (carry > 0) s.append(carry);
        return s.reverse().toString();
    }

    private String evenUpStrings(String x, int diff) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < diff; i++) {
            s.append("0");
        }
        s.append(x);
        return s.toString();
    }
}