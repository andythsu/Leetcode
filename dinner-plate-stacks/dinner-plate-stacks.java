class DinnerPlates {
    Stack<Stack<Integer>> stacks;
    TreeSet<Integer> set = new TreeSet<>();

    private int cap;

    public DinnerPlates(int capacity) {
        this.cap = capacity;
        stacks = new Stack<>();
    }

    public void push(int val) {
        if (set.size() != 0) {
            int idx = set.iterator().next();
            stacks.get(idx).push(val);
            if (stacks.get(idx).size() == cap) {
                set.remove(idx);
            }
        } else {
            if (stacks.isEmpty() || stacks.peek().size() == cap) {
                stacks.add(new Stack<>());
                stacks.peek().add(val);
            } else {
                stacks.peek().add(val);
            }
        }
    }

    public int pop() {
        if (!stacks.isEmpty()) {
            int k = stacks.peek().pop();
            while (!stacks.isEmpty() && stacks.peek().isEmpty()) {
                set.remove(stacks.size() - 1);
                                stacks.pop();
            }
            return k;
        }
        return -1;
    }

    public int popAtStack(int index) {
        if (index >= stacks.size() || stacks.get(index).size() == 0) {
            return -1;
        }
        if (index == stacks.size() - 1) {
            return this.pop();
        }
        set.add(index);
        return stacks.get(index).pop();
    }

}