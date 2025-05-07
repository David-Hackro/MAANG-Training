class Solution {
    
    public int maximizeSweetness(int[] sweetness, int k) {
        long l = 1l;
        long r = 0l;
        long m = 0l;
        int counter = 0;
        long sum = 0;
        long result = 0;

        for(int n : sweetness) {
            r += n;
        }

        if(k == 0) {
            return (int)r;
        }

        while(l < r) {
            m = (l + r) / 2;
            sum = 0l;
            counter = 0;

            for(int n: sweetness) {
                sum+=n;

                if(sum >= m) {
                    sum = 0;
                    counter++;
                }
            }


            if(counter < k + 1) {
                r = m;
            } else {
                result = Math.max(result, m);
                l = m + 1;
            }
        }


        return (int)result;
    }
}