class Solution {
    public int minMoves(int target, int maxDoubles) {
        int result = 0;
        int current = target;

        if(target == 1) {
            return 0;
        }

        //19
        //2
        while (current / 2 > 1 && maxDoubles > 0) {
            result += current%2;//1
            current-= current%2;//1
            current /=2;
            result++;
            maxDoubles--;
        }


        if(current > 0) {
            result+= (current -1);
        }

        return result;

    }
}