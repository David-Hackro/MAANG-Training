class Solution {
    public int[] maximumLengthOfRanges(int[] nums) {
        int[] results = new int[nums.length];
        Stack<Integer> leftToRight = new Stack<>();
        Stack<Integer> rightToLeft = new Stack<>();

        for(int i = 0; i < nums.length; i++) {

            while(!leftToRight.isEmpty() && nums[i] > nums[leftToRight.peek()]) {
                results[leftToRight.peek()] += i - leftToRight.pop();
            }

            leftToRight.push(i);
        }       

        while(!leftToRight.isEmpty()) {
            results[leftToRight.peek()] += nums.length - leftToRight.pop();
        }

        for(int i = nums.length -1; i >= 0; i--) {
            while(!rightToLeft.isEmpty() && nums[i] > nums[rightToLeft.peek()]) {
                results[rightToLeft.peek()] += rightToLeft.pop() - i - 1;
            }

            rightToLeft.push(i);
        }

        while(!rightToLeft.isEmpty()) {
            results[rightToLeft.peek()] += rightToLeft.pop();
        }

        return results;
    }
}