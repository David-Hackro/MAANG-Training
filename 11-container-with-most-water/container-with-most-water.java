class Solution {

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        int min = 0;

        while (l < r) {
            min = Math.min(height[l], height[r]);
            max = Math.max(max, ((r - l) * min));

            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }

        min = Math.min(height[l], height[r]);
        max = Math.max(max, ((r - l) * min));

        return max;
    }
}