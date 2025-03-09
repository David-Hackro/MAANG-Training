class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      int l = 0;
      int r = 0;
      int counter = 0;
      int m = 0;
      int result = Integer.MAX_VALUE;
      
      for(int n: piles) {
        r = Math.max(r, n);
      }  

      while(l <= r) {
        counter = 0;
         m = (l + r) / 2;

        for(int i = 0; i < piles.length; i++) {
            counter += Math.ceil((double) piles[i] / m);
        }
        
        if(counter <= h) {
            result =  m;
        }
        
        if(counter <= h) {
            r = m -1;
        } else {
            l = m + 1;
        }
      }

      return result;
    }
}