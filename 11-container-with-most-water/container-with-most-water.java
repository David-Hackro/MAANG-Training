class Solution {
    public int maxArea(int[] height) {
        
        int ans = 0;
        int l = 0;
        int r = height.length -1;
        int min = 0;
        int temp = 0;

        while(l <= r) {
            min = Math.min(height[l], height[r]);

            temp = min * (r - l);

            ans = Math.max(ans, temp);
            
            if(height[l] > height[r]){
                r--;
            } else{
                l++;
            }
        }

        return ans;
    }
}