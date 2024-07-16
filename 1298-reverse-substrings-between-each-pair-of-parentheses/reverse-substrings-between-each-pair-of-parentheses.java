class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()) {
            if(c != ')') {
                stack.push(c);
            } else {
                sb = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop(); //remove (

                for(char ch : sb.toString().toCharArray()) {
                    stack.push(ch);
                }
            }
        }      

        sb = new StringBuilder();
        while(!stack.isEmpty()) {
            if(stack.peek() != '(') {
                sb.append(stack.pop());
            }
        }

        return sb.reverse().toString();
    }
} 