class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        //[1,2,3,4,2,3,3,5,7]

        //7,5,3
        for(int i = nums.length - 1; i >=0; i--) {
            
            if(numbers.contains(nums[i])) {
                int numberElements = i + 1;
                if(numberElements % 3 == 0) {
                    return numberElements / 3;
                } else {
                    return (numberElements / 3) + 1;
                }
                
                    //index == 5
                    //5 + 1 / 3 = 
            } 


            numbers.add(nums[i]);

        }

        return 0;
    }
}