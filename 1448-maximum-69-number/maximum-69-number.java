class Solution {
    public int maximum69Number(int num) {
        int result = 0;
        int m = 1;
        int length = 0;
        int numercopy = num;
        int position = 0; // position first 6 l -> r
        int index = 0;

 
        while (numercopy != 0) {
            int res = numercopy % 10;

            if (res == 6) {
                position = length;
            }

            numercopy = numercopy / 10;
            length++;
        }
        
        while (num != 0) {
            int res = num % 10;

            if (index == position) {
                res = 9;
            }

            result = result + (res * m);

            num = num / 10;
            index++;
            m *= 10;
        }

        return result;
    }
}