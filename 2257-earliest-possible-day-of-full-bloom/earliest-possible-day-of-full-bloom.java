class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {

        int[][] pairs = new int[plantTime.length][2];
        
        for(int i = 0; i < plantTime.length; i++) {
            pairs[i] = new int []{plantTime[i], growTime[i]};
        }

        Arrays.sort(pairs, (a,b) -> {
 if (a[1] == b[1]) {
        return Integer.compare(a[0], b[0]); 
    } else {
        return Integer.compare(b[1], a[1]);
    }
        });

        int time = 0;
        int max = 0;

        for(int i = 0; i < pairs.length; i++) {
            time += pairs[i][0];
            int bloomDay = time + pairs[i][1];
            max = Math.max(max, bloomDay);
        }

        return max;
    }
}