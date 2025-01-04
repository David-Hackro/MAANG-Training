import java.math.BigInteger;

class Solution {
    public int numTrees(int n) {
        BigInteger r = getFactorial(n * 2);// -522715136
        BigInteger s = getFactorial(n + 1);// 479001600
        BigInteger t = getFactorial(n);// 39916800
        BigInteger x = s.multiply(t);
        BigInteger total = r.divide(x);

        return total.intValue();
    }

    private BigInteger getFactorial(int n) {
        BigInteger r = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            r = r.multiply(BigInteger.valueOf(i));
        }

        return r;
    }
}