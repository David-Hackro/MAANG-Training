class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] min = new int[rows];
        int[] max = new int[cols];
        List<Integer> results = new ArrayList<>();

        for(int i = 0; i < rows; i++) {
            //elemento mínimo en su fila y máximo en su columna.
            

            for(int j = 0; j < cols; j++) {
                
                if(max[j] == 0) {
                    max[j] = Integer.MIN_VALUE;
                }

                if(min[i] == 0) {
                    min[i] = Integer.MAX_VALUE;
                }

                min[i] = Math.min(matrix[i][j], min[i]);
                max[j] = Math.max(matrix[i][j], max[j]);
            }
        }

        Arrays.sort(min);
        Arrays.sort(max);

        for(int i = max.length - 1; i >= 0; i--) {

            for(int j = min.length - 1; j >= 0; j--) {
                
                if(min[j] < max[i]) {
                    break;
                } else if(max[i] == min[j]) {
                    results.add(max[i]);
                }
            }
        }

        return results;
        
    }
}