class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] values = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] simbols = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        for(int i = 0; i < values.length; i++) {

            while(values[i] <= num) {
                num -= values[i];
                sb.append(simbols[i]);
            }
        }
        
        return sb.toString();

    }
}
