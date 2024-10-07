class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()) {
            
            if(stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            String w = stack.peek() + ""+ c;

            if(w.equals("AB") ||  w.equals("CD")) {
                stack.pop();
                continue;
            }

            stack.push(c);
        }

        return stack.size();
    }
}