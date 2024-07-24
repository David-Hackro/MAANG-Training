class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int index = 0;

        for(int n: nums) {
            String numb = String.valueOf(n);
            StringBuilder mappedNumber = new StringBuilder();

            for (char c : numb.toCharArray()) {
                int digit = Character.getNumericValue(c);
                mappedNumber.append(mapping[digit]);
            }
            List<Integer> list = map.getOrDefault(Integer.parseInt(mappedNumber.toString()), new ArrayList<>());
            list.add(n);
            map.put(Integer.parseInt(mappedNumber.toString()), list);
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            
            for(int n: entry.getValue()) {
                nums[index++] = n;
            }

        }

        return nums;
    }
}