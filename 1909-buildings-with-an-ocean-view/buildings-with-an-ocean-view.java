class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int[] result;

        for(int n: heights) {

            while(!stack.isEmpty() && heights[stack.peek()] <= n) {
                stack.pop();
            }

            stack.push(i++);
        }       

        result = new int[stack.size()];
        i = stack.size() - 1;
        while(!stack.isEmpty()) {
            result[i--] = stack.pop();
        }

        return result;
    }
}