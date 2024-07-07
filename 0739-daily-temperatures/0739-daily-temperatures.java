class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int cur = temperatures[i];
            while(!stack.isEmpty() && stack.peek()[0] < cur) {
                int[] val = stack.pop();
                res[val[1]] = i - val[1];
            }
            stack.push(new int[]{cur,i});
        }
        return res;
    }
}