class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        String[] result = new String[names.length];
        HashMap<Integer, String> map = new HashMap<>();
        int index = 0;
        for(int i = 0; i < names.length; i++) {
            map.put( heights[i],names[i]);
        }       

        Arrays.sort(heights);

        for(int i = heights.length - 1; i >= 0; i--) {
            result[index++]= map.get(heights[i]);
        }

        return result;

    }
}