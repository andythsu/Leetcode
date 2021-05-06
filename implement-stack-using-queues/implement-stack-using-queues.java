class MyStack {
    
    Queue<Integer> q;
    int top;

    /** Initialize your data structure here. */
    public MyStack() {
        q = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
        top = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = q.size();
        if(size > 1){
            for(int i=0; i<size - 1; i++){
                int cur = q.remove();
                q.add(cur);
                if(i == size - 2) top = cur;
            }
        }
        return q.remove();
    }
    
    /** Get the top element. */
    public int top() {
        if(q.isEmpty()) return -1;
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */