class Solution {
    public int maximumSwap(int num) {
        //1993
        char[] arrayOriginalNumber = (num + "").toCharArray();
        char[] arrayMax = (num + "").toCharArray();
        //[1,9,9,3]
        
        int max = 48;

        for(int i = arrayMax.length -1; i >= 0; i--) {
            max = Math.max(max, arrayMax[i]);
            arrayMax[i] = (char) max;
        }
        
        char replaceValue = ' ';

        for(int i = 0; i < arrayMax.length; i++) {
            //[9,9,9,3]
            //[9,9,9,3]
            char originalValue = arrayOriginalNumber[i];//1
            char maxValue = arrayMax[i];//9

            if(maxValue > originalValue) {//9 > 1
                //trarversal starting from the right side until i + 1;
                
                for(int j = arrayOriginalNumber.length -1; j >= i; j--) {
                    
                    //search the first coincidence of arrayMax[i] starting in the right side and replace by arrayOriginalNumber[i]

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