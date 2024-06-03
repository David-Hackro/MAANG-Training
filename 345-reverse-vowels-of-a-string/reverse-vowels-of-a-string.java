class Solution {
    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        List<Character> list = new ArrayList<>(Arrays.asList(
            'a', 'e', 'i', 'o', 'u', 
            'A', 'E', 'I', 'O', 'U'
        ));        
        int l = 0;
        int r = s.length() -1;

        while(l < r){
          
          if(list.contains(array[l]) && list.contains(array[r])) {
            array[l] = s.charAt(r);
            array[r] = s.charAt(l);
            l++;
            r--;
          } else {
            if(!list.contains(array[l])) l++;
            if(!list.contains(array[r])) r--;
          }
        }

        return new String(array);
    }
}