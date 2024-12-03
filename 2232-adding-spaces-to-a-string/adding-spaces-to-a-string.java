class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int i = 0; //spaces

        //s = "icodeinpython", spaces = [1,5,7,9]
        for(int index = 0; index < s.length(); index++) {
            
            if(i <  spaces.length && spaces[i] == index) {
                sb.append(" ");
                i++;
            }

            sb.append(s.charAt(index)); //i
        }

        return sb.toString();
        }
}