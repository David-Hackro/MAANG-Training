class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length();i++) {
            
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }

            if(s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }

            stack.push(s.charAt(i));
        }


       
       return stack.size(); 
    }
}