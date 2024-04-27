class Solution {
    public boolean isHappy(int n) {
        int copy = n;
        List<Integer> results = new ArrayList<>();
        results.add(copy);

        while(copy != 1) {
            int t = copy;
            copy = 0;

            while(t != 0) {
                copy += (t % 10) * (t % 10);
                t/=10;
            }

            if(results.contains(copy)) {
                return false;
            }

            results.add(copy);

        }

        return true;    
    }
}