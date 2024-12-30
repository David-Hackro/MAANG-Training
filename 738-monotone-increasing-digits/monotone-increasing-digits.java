class Solution {
    public int monotoneIncreasingDigits(int n) {
        if(n == 0) { return 0 ;}

        String number = n + "";
        char[] result = number.toCharArray();
        int i = 0;
        // 3324
        // move the pointer until broke the rule x <= y)
        while (i < number.length() - 1 && number.charAt(i) <= number.charAt(i + 1)) {
            i++;
        }

        for (int j = i + 1; j < result.length; j++) {
            result[j] = '9';
        }

        if (i == 0) { // where is the first slot
            int num = result[0] - '0';// 4
            result[0] = (char) (num + 48 - 1);
        } else if(i  != result.length -1) {
            // 3 3 9
            int res = result[i] - '0';
            res -= 1;// 2

            if (res >= result[i - 1] - '0') {
                result[i] = Character.forDigit(res, 10);
            } else {// 399
                // update meanwhile the conditional still false

                while (i > 0 && (result[i] - '0' - 1) < (result[i - 1] - '0')) {
                    result[i] = '9';
                    i--;
                }

                result[i] = (char) (result[i] - 1);
            }
        }

        return Integer.parseInt(new String(result));
    }
}