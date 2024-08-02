class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int hight = nums.length - 1;
        /*
        Si encontramos un 0, intercambiamos nums[low] y nums[mid], incrementamos low y mid.
            Si encontramos un 1, simplemente incrementamos mid.
            Si encontramos un 2, intercambiamos nums[mid] y nums[high], decrementamos high.
        */
        while(mid <= hight) {
            switch (nums[mid]) {
                 case 0: 
                        int y = nums[low];
                        nums[low] = nums[mid];
                        nums[mid] = y;
                        low++;
                        mid++;
                    break;

                    case 1: 
                            mid++;
                        break;

                        case 2:
                            int x = nums[mid];
                            nums[mid] = nums[hight];
                            nums[hight] = x;
                            hight--;
                         break;

            }
        }       

    }
}