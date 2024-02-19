class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < pushed.length) {
            
            if(!list.isEmpty() && list.get(list.size() -1) == popped[j]) {
                list.remove(list.size()-1);
                j++;
            } else {
                list.add(pushed[i]);
                i++;
            }
        }

        while(!list.isEmpty() && list.get(list.size() -1) == popped[j]) {
            list.remove(list.size()-1);
            j++;
        }

        return list.isEmpty();
    }
}