class Solution {
    public String licenseKeyFormatting(String s, int k) {
        
        StringBuilder sb = new StringBuilder();
        int j = k;

        for(int i = s.length() -1; i >= 0; i--) {
            if(s.charAt(i) != '-') {
                if(j > 0) {
                    sb.append(Character.toUpperCase(s.charAt(i)));
                    j--;
                } else {
                    sb.append('-');
                    sb.append(Character.toUpperCase(s.charAt(i)));
                    j = k -1;
                }
            }
        }

        return sb.reverse().toString();
    }
}