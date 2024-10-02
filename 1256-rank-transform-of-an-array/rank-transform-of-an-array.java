class Solution {
    public int[] arrayRankTransform(int[] arr) {
            //value , indexs
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] result = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }

            map.get(arr[i]).add(i);
        }

        Arrays.sort(arr);
        int i = 1;
        int j = 0;

        while(!map.isEmpty() && j < arr.length) {

            List<Integer> list = map.get(arr[j]);

            for(int n: list) {
                result[n] = i;
                j++;
            }

            i++;
        }

        return result;
    }
}