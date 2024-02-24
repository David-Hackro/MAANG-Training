/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;

        while(l < r) {
            
            if(isBadVersion(l + (r - l) / 2)) {
                r = l + (r - l) / 2;
            } else {
                l  = l + ((r - l) / 2) + 1;
            }
        }

        return r;
    }
}