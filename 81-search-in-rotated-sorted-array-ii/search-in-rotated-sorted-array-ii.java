class Solution {

    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[l] == target) {
                return true;
            }

            //// [2,5,6,8,0,1,2]
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l++;
                r--;
            } else if (nums[l] <= nums[mid]) {

                if (nums[l] <= target && target <= nums[mid]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            } else if (nums[mid] <= nums[r]) {
                if (nums[mid] <= target && target <= nums[r]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
        }

        return false;
    }
}