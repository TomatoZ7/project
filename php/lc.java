class MyQueue {
    Deque<Integer> pushStack;   // 用于压栈
    Deque<Integer> popStack;    // 用于出栈

    public MyQueue() {
        pushStack = new LinkedList<Integer>();
        popStack = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        if (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        pushStack.push(x);
    }
    
    public int pop() {

    }
    
    public int peek() {

    }
    
    public boolean empty() {

    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */