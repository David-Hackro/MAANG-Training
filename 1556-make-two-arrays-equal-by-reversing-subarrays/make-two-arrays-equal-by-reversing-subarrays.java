class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < target.length; i++){
            //target ++
            map.put(target[i], map.getOrDefault(target[i],0 ) + 1);

            //arr --
            map.put(arr[i], map.getOrDefault(arr[i],0 ) - 1);
        }

        Set<Integer> set = new HashSet<>();
        set.addAll(map.values());

        if(set.size() > 1 ) {
            return false;
        }

        return set.iterator().next() == 0;        
    }
}