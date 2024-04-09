class Solution {
    public int maxWidthRamp(int[] nums) {
        
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        
        stack.push(0);

        for(int i = 1; i < nums.length; i++) {
            
            if(nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }


        for(int i = nums.length - 1; i >= 0; i--) {

            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                result = Math.max(result, i - stack.pop());
            }
        }

        return result;

    }
}