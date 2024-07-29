class Solution {
    public int[] findBuildings(int[] heights) {
        int[] result;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < heights.length; i++){
            
            while(!stack.isEmpty() && heights[i] >= heights[stack.peek()]){
                stack.pop();
            }

            stack.push(i);
        }

        result = new int[stack.size()];

        for (int i = result.length -1; i>=0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}