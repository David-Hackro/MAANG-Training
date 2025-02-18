class Solution {
    public String smallestNumber(String pattern) {
        char[] result = new char[pattern.length() + 1];
        int index = 0;// 3
        int j = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 9; i > 0; i--) {
            stack.push((char) (48 + i));
        }

        while (j < pattern.length()) {
            char ch = pattern.charAt(j);
            
            if (ch == 'I') {
                result[index] = stack.pop();
                j++;
                index++;
            } else {
                int k = j;
                int r = 0;
                // DDD
                while (k < pattern.length() && pattern.charAt(k) == 'D') {
                    k++;// 3
                }

                index = k;

                while (j <= index) {
                    result[index--] = stack.pop();
                }

                index = k + 1;
                j = index;
            }

        }

        if (index < result.length) {
            result[result.length - 1] = stack.pop();
        }

        return String.valueOf(result);
    }
}
