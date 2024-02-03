class MinStack {
    HashMap<Integer, Integer> map;
    int index = 0;
    // -2,0,-3
    //["MinStack","push","push","push","getMin","pop","top","getMin"]

    public MinStack() {
        map = new HashMap<>();
    }
    
    public void push(int val) {
        map.put(index++, val);
    }
    
    public void pop() {
        map.remove(map.size() -1);
        index--;
    }
    
    public int top() {
        int result = map.get(map.size() -1);
        return result;
    }
    
    public int getMin() {
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);

        return list.get(0);
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