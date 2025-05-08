class Solution {
    public int splitArray(int[] nums, int k) {
        long l = 0l;
        long r = 0l;
        long m = 0l;
        long sum = 0l;
        int counter = 0;
        int max = 0;

        for (int n : nums) {
            max = Math.max(max, n);
            r += n;
        }

        l = max;
        while (l < r) {
            m = (l + r) / 2;
            sum = 0;
            counter = 1;

            for (int n : nums) {
            
                if (sum + n > m) {
                    sum = 0;
                    counter++;
                }

                sum +=n;
            }

            if (counter <= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return (int) l;
    }
}