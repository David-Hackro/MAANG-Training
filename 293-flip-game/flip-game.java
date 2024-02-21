class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> result = new ArrayList<>();

        for(int i = 1; i < currentState.length(); i++) {
            char[] t = currentState.toCharArray();

            if(t[i-1] == '+' && t[i] == '+') {
                t[i-1] = '-';
                t[i] = '-';
                result.add(new String(t));
            }
        }


        return result;
    }
}