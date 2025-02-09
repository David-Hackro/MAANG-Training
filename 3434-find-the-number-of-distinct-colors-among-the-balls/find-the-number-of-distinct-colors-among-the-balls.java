class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> ballsMap = new HashMap<>();
        HashMap<Integer, Integer> colorsMap = new HashMap<>();
        int[] result = new int[queries.length];
        int index = 0;

        for(int[] q: queries) {
            int ball = q[0];
            int color = q[1];

            if(ballsMap.containsKey(ball)) {
                int prevColor = ballsMap.get(ball);
                
                colorsMap.put(prevColor, colorsMap.get(prevColor) -1);
                if(colorsMap.get(prevColor) == 0) {
                    colorsMap.remove(prevColor);
                }
            }

            //insert color
            colorsMap.put(color, colorsMap.getOrDefault(color, 0) + 1);
            ballsMap.put(ball, color);

            result[index++] = colorsMap.size();
        } 

        return result;
    }
}