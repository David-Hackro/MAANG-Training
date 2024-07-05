class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;

        for(int p : position) {
            map.put(p, i++);
        }
    
        Arrays.sort(position);
        
        for(int p : position) {
            double n = (double) (target - p) / speed[map.get(p)];

            while(!stack.isEmpty() && stack.peek() <= n) {
                stack.pop();
            }

            stack.push(n);
        }

        return stack.size();       
    }
}