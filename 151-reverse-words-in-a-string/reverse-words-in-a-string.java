class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] results = s.split(" ");

        for(int i = results.length -1; i >=0; i--){
            if(results[i] != "") {
            if(i != results.length -1) {
                sb.append(" ");
            }
            
            sb.append(results[i]);
            }
        }       

        return sb.toString();
    }
}