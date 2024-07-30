class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int[] result = new int[heights.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = heights.length -1; i>=0; i--) {
            int counter = 0;

            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                stack.pop();
                counter++;
            }

            if(!stack.isEmpty())
                counter++;

             result[i] = counter;
             stack.push(heights[i]);
        }

        
        return result;
    }
}