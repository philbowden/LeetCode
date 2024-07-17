class MinStack {
    private Stack<Integer> mins = new Stack<>();
    private Stack<Integer> stack = new Stack<>();

    public MinStack() {}
    
    public void push(int val) {
        if (mins.isEmpty() || mins.peek() >= val) {
            mins.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
        if (!mins.isEmpty() && stack.peek().equals(mins.peek())) mins.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */