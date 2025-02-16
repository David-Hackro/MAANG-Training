class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> result = new ArrayList<Long>();
        long total = 0;
        long number = 2;

        if(finalSum % 2 != 0) {
            return result;
        } else if(finalSum == 2) {
            result.add(Long.valueOf(2));
            return result;
        }

        //where is even, the multiples


        while(total < finalSum) {
            total += number;// 0 + 2
                
            if(total > finalSum) {//where the sum is greather that finalSum
                long lastItem = result.get(result.size() -1);
                total-= number;
                total -= lastItem;
                result.remove(result.size() -1);
                result.add(finalSum - total);
                return result;   
            }

            result.add(number);

            number +=2;
        }

        return result;
    }
}