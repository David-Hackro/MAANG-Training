class SparseVector {
    int[] nums;

    SparseVector(int[] nums) {
        this.nums = nums;    
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int[] nums2 = vec.nums;
        int result = 0;


        for(int i = 0; i < nums.length; i++) {
            result = result + (nums[i] * nums2[i]);
        }

        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);nums1 = [1,0,0,2,3]
// SparseVector v2 = new SparseVector(nums2);nums2 = [0,3,0,4,0]
// int ans = v1.dotProduct(v2);