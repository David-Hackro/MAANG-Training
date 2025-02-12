class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = -1;

        // [18,43,36,13,7]
        // [9 , 7,9, 4, 7]
        for (int n : nums) {
            int sum = getSumOfDigits(n);// 9

            // sum the digits
            if (map.containsKey(sum)) {
                max = Math.max(max, n + map.get(sum));
            }

            map.put(sum, Math.max(map.getOrDefault(sum, 0), n));
        }

        return max;
    }

    private int getSumOfDigits(int n) {
        int result = 0;

        while (n != 0) {
            result += (n % 10);
            n /= 10;
        }

        return result;
    }
}
