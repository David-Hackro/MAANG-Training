class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int turns = 0;
        int index  = 0;

        for (int i = 0; i < dist.length; i++) {
            int residual = dist[i] % speed[i] == 0 ? 0 : 1;
            int turn = (int) (dist[i] / speed[i]) + residual;
            dist[i] = turn;
        }

        Arrays.sort(dist);

        while (index < dist.length && dist[index] > turns) {
            turns++;
            index++;
        }

        if (index != dist.length) {
            return turns;
        }

        return dist.length;
    }
}