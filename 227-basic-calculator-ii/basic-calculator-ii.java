class Solution {
    public int calculate(String s) {
        Deque<Integer> values = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();
        List<Character> simbols = new ArrayList<>();
        simbols.add('+');
        simbols.add('-');
        simbols.add('*');
        simbols.add('/');
        int result = 0;

        int i = 0;
        int temp = 0;
        
        for(; i < s.length();) {
            char c = s.charAt(i);

            if(simbols.contains(c)) {
                operators.add(c);
                i++;
            } 
            else if(c == ' ') { i++;}
            else {
                temp = 0;

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    temp = temp * 10 + (s.charAt(i) - '0');
                    i++;
                }
                
              if (!operators.isEmpty() && (operators.peekLast() == '*' || operators.peekLast() == '/')) {
                    char op = operators.pollLast();
                    int prev = values.pollLast();
                    temp = op == '*' ? prev * temp : prev / temp;
                }
                
                values.add(temp);

            }
        }

        result = values.pollFirst();

        while(!values.isEmpty()) {
            char op = operators.pollLast();
            int prev = values.pollLast();
    
            result = op == '+' ? result + prev : result - prev;
        }

        return result;
    }
}
