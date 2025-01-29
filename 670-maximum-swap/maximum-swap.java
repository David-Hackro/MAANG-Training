class Solution {
    public int maximumSwap(int num) {
        char[] arrayOriginalNumber = (num + "").toCharArray();
        char[] arrayMax = (num + "").toCharArray();
        
        int max = '0';

        for(int i = arrayMax.length -1; i >= 0; i--) {
            max = Math.max(max, arrayMax[i]);
            arrayMax[i] = (char) max;
        }
        
        for(int i = 0; i < arrayMax.length; i++) {

            char originalValue = arrayOriginalNumber[i];
            char maxValue = arrayMax[i];

            if(maxValue > originalValue) {
                
                for(int j = arrayOriginalNumber.length -1; j >= i; j--) {

                    if(arrayMax[i] == arrayOriginalNumber[j]) {
                        arrayOriginalNumber[j] = arrayOriginalNumber[i];
                        arrayOriginalNumber[i] = maxValue;

                        String result = new String(arrayOriginalNumber);
                        
                        return (int) Integer.parseInt(result);
                    }
                }
            }    
        }


        return num;
    }
}