class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length -1;
        int max = 0;
        int min = Integer.MAX_VALUE;
        //[1,8,6,2,5,4,8,3,7]
        
        while(l < r) {
            min = Math.min(height[l], height[r]);
            max = Math.max(max, min * (r - l));

            if(height[l] == min) {
                l++;
            } else{ 
                r--;
            }
            min = Integer.MAX_VALUE;
        }

        return max;
    }
}