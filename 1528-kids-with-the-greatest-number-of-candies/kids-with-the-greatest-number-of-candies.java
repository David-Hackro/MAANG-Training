class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        int max = Integer.MIN_VALUE;
        int i =0;
        int j = candies.length -1;
        List<Boolean> result = new ArrayList();
        for(; i <=j; i++) {
            max = Math.max(max, candies[i]);
            max = Math.max(max, candies[j--]);
        } 

        i =0;
        for(; i <candies.length; i++) {
            result.add(candies[i] == max || ((candies[i] + extraCandies) >= max));
        } 

        return result;
    }
}