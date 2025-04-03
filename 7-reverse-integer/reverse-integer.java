class Solution {
    public int reverse(int x) {
        //32-bit signed integer in 2's complement representation has the range -231 to 231-1 which is equal to -2,147,483,648 to 2,147,483,647    
        //Integer.MAX_VALUE =  2147483647 > 10000000000
        //Integer.MIN_VALUE = -2147483648

        //#1 : reverse number
        int original = x;
        long m = 1L;//x
        int result = 0;
        int lastDigit = 0;

        while (x != 0) {
            lastDigit = x % 10;
            x /= 10;
            m *= 10l;
        }

        m /= 10;
        int n = (int) m;
        long temp = 0l;

        while (original != 0) {
            lastDigit = original % 10;
            temp = Long.valueOf(result) + (Long.valueOf(lastDigit) * Long.valueOf(n));

            if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
                return 0;
            }
            result = result + (lastDigit * n);
            original /= 10;
            n /= 10;
        }

        return result;
    }
}