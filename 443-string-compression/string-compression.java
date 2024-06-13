class Solution {
    public int compress(char[] chars) {
        int l = 0;
        int r = 0;
        int i = 0;

        while(r < chars.length) {
            //["a","b","b","b","b","b","b","b","b","b","b","b","b"]
            //


            while(r < chars.length && chars[l] == chars[r]) {r++;}

            chars[i] = chars[l];
            
            if(r - l > 1) {
                if(r - l > 9 ) {
                    String number = String.valueOf((r - l));

                    for(int j = 0; j < number.length(); j++) {
                        chars[++i] = (char) (number.charAt(j));        
                    }

                } else {
                chars[i +1] = (char) ((r- l) + '0');
                i++;
                }
            }
            i++;
            l = r;
        }       

        return i;
    }
}