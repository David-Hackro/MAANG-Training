class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        long l = 1l;
        long r = 0l;
        long m = 0l;
        long sum = 0l;
        long min = 0l;
        HashSet<Long> seen = new HashSet<>();

        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            r = Math.max(r, n);
            min = r;
        }
        
        while(!seen.contains(m)) {
            sum = 0l;
            m = (l + r) / 2;
            seen.add(m);

            Iterator it = map.entrySet().iterator();
           
              for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                int value = pair.getKey();
                int freq = pair.getValue();

                long res = (value + m - 1) / m; 
                sum += res * freq;
            }
            
            if(sum <= threshold) {
                min = Math.min(min, m);
                r = m;
            } else {
                l = m + 1;
            }
            
            m = (l + r) / 2;
        }

        return (int)min;        

    }
}