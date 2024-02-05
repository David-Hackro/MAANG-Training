class Solution {
    public String reverseOnlyLetters(String s) {
            int l = 0;
            int r = s.length() - 1;
            char[] array = s.toCharArray();

            while(l < r) {
                if(Character.isLetter(array[l]) && Character.isLetter(array[r])){
                    char temp = array[r];
                    array[r] = array[l];
                    array[l] = temp;
                    l++;
                    r--;
                } 

                if(!Character.isLetter(array[l])) {
                    l++;
                }

                if(!Character.isLetter(array[r])) {
                    r--;
                }
            }

            return new String(array);      
       }
}