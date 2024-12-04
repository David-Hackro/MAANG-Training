class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int l = 0;
        int r = 0;

        if (str2.length() > str1.length()) {
            return false;
        }

        if(str1.equals(str2)) {
            return true;
        }


        while (l < str1.length() && r < str2.length() && str1.length() - l >= str2.length() - r) {

            if (str1.charAt(l) == str2.charAt(r)) {
                r++;
            } else if ((str1.charAt(l) - 'a') - (str2.charAt(r) - 'a') == -1
                    || str1.charAt(l) == 'z' && str2.charAt(r) == 'a') {
                r++;
            }

            l++;
        }

        return r == str2.length();
    }
}