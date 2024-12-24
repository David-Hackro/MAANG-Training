class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        Stack<int[]> stack = new Stack<>();

        // [[0,0,1,4],[1,0,2,3],[1,3,4,4],[2,0,3,3],[3,0,4,3]]//ROW
        Arrays.sort(rectangles, (a, b) -> {
            // [startx, starty, endx, endy]
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[3], b[3]);
        });

        for(int[] rec: rectangles) {
        
            if(stack.isEmpty()) {
                stack.push(rec);
                continue;
            } 

            //the new rec is inside the range to another?
            if(rec[1] >= stack.peek()[1] && rec[1] < stack.peek()[3]) {
                int[] temp = stack.pop();
                temp[1] = Math.max(temp[1], rec[1]);
                temp[3] = Math.max(temp[3], rec[3]);
                stack.push(temp);
            }else {
                stack.push(rec);
            }
        
        }

        if(stack.size() >= 3) {
            return true;
        }

        stack.clear();

        // [[0,0,1,4],[1,0,2,3],[1,3,4,4],[2,0,3,3],[3,0,4,3]]//ROW
        Arrays.sort(rectangles, (a, b) -> {
            // [startx, starty, endx, endy]
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(a[2], b[2]);
        });

        for(int[] rec: rectangles) {
        
            if(stack.isEmpty()) {
                stack.push(rec);
                continue;
            } 

            //the new rec is inside the range to another?
            if(rec[0] >= stack.peek()[0] && rec[0] < stack.peek()[2]) {
                int[] temp = stack.pop();

                temp[0] = Math.max(temp[0], rec[0]);
                temp[2] = Math.max(temp[2], rec[2]);
                stack.push(temp);
            }else{
                stack.push(rec);
            }
        
        }


       
        return stack.size() >= 3;
    }

}