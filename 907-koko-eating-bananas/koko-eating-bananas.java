class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int l = 1;//min speed
        int mid = 0;
        int r = 0;//max speed
        int counter = 0;

        for(int p: piles) {
            r = Math.max(r, p);
            l = Math.min(l, p);
        }

        if(piles.length == h) {
            return r;
        }      

        while(l <= r)  {
            mid = l + ((r - l) / 2);
            counter = 0;

            for(int p : piles) {
                counter += (int) Math.ceil((double) p / mid);
                if(counter > h) break;
            }

            if(counter > h) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        } 

        return l;
    }
}