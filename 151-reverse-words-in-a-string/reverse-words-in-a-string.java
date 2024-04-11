class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        
        int i = s.length() -1;        
        int j = s.length() -1;

        for(; i >=0; i--){
            if(s.charAt(i) == ' ' && s.charAt(j) == ' ') {
                j--;
            } 
             else if(s.charAt(i) == ' ' && s.charAt(j) != ' ') {
                if(!sb.isEmpty()) {
                    sb.append(" ");
                }
                sb.append(s.substring(i +1, j +1));
                j = i;
            } else if(s.charAt(i) != ' ' && s.charAt(j) == ' ') {
                j--;
            }
        }       
        
        if(!sb.isEmpty() && s.charAt(i+1) != ' ' && s.charAt(j) != ' ') {
            sb.append(" ");
        }

        if(s.charAt(i+1) != ' ' && s.charAt(j) != ' ') {
            sb.append(s.substring(i +1, j +1));
        }            
        
   

        return sb.toString();
    }
}