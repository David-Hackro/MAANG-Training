class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int result = 0;
        int counter = 0;

        for(int n : weight){
            
            if(counter + n <= 5000) {
                result++;
                counter += n;
            } else {
                return  result;
            }
            
        }

        return result;
    }
}