class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack= new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;

        for(char c : s.toCharArray()) {
            if(c == '(' || c == ')' ) {

                if(stack.isEmpty() || c == '(') {
                    stack.push(i);
                } else {

                    if(s.charAt(stack.peek()) == '(') {
                        stack.pop();
                    } else {
                        stack.push(i);
                    }
                }
            }
            i++;
        }

        i = 0;
        for(char c : s.toCharArray()) {
            if(!stack.contains(i)) {
                sb.append(c);
            }

            i++;
        }

        return sb.toString();
    }
}