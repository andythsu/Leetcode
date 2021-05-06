class MyQueue {
    
    Stack<Integer> dataStack;
    Stack<Integer> popStack;
    int top = -1;
    int dataTop = -1;

    /** Initialize your data structure here. */
    public MyQueue() {
        dataStack = new Stack<>();
        popStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(dataStack.isEmpty()) dataTop = x;
        dataStack.push(x);
        if(top == -1) top = x;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(empty()) return -1;
        if(popStack.isEmpty()){
            while(!dataStack.isEmpty()){
                popStack.push(dataStack.pop());
            }
        }
        int rtn = popStack.pop();
        if(empty()){
            top = -1;
        }else if(popStack.isEmpty()){
            top = dataTop;
        }else{
            top = popStack.peek();
        }
        return rtn;
    }
    
    /** Get the front element. */
    public int peek() {
        return top;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return popStack.isEmpty() && dataStack.isEmpty();
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