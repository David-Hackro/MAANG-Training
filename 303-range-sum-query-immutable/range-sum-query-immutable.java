class NumArray {
    int[] values = new int[0];

    public NumArray(int[] nums) {
        values = nums;        
    }
    
    public int sumRange(int left, int right) {
        int counter = 0;

        for(int i = left; i <= right; i++) {
            counter+= values[i];
        }

        return counter;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */