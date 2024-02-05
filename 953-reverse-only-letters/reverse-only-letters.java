class Solution {
    public String reverseOnlyLetters(String s) {
        char[] result = new char[s.length()];
        int l = 0;
        int r = s.length() - 1;
        
        String letters = "abcdefghijklmnopqrstvuwxyz";


        while(l <= r) {

            if(letters.contains(Character.toLowerCase(s.charAt(l)) +"") && 
               letters.contains(Character.toLowerCase(s.charAt(r)) +"")) {
                
                result[r] = s.charAt(l);
                result[l] = s.charAt(r);
                l++;
                r--;
            } else {
                if(!letters.contains(Character.toLowerCase(s.charAt(l)) +"")){
                    result[l] = s.charAt(l);
                    l++;
                }

                if(!letters.contains(Character.toLowerCase(s.charAt(r)) +"")){
                    result[r] =  s.charAt(r);
                    r--;
                }
            }

        }
        



        return new String(result);
    }
}