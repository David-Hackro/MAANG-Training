class Solution {
    public int maxSum(int[] nums) {
    int result = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    char last = ' ';

    for(int n : nums) {
        char[] digits = (n + "").toCharArray();
        Arrays.sort(digits);
        last = digits[digits.length -1];

        if(map.containsKey(last)) {
            result = Math.max(result, map.get(last) + n);
        }

        map.put(last, Math.max(n, map.getOrDefault(last, 0)));
    }

    if(result == 0) {
        return -1;
    }
    
    return result;  
    }
}