class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            if (!map.containsKey(spells[i])) {
                map.put(spells[i], new ArrayList<>());
            }

            map.get(spells[i]).add(i);
        }

        Arrays.sort(spells);// [1,3,5]
        Arrays.sort(potions);// [1,2,3,4,5]

        for (int i = spells.length - 1; i >= 0; i--) {
            int spell = spells[i];
            int numbers = getValues(spell, potions, success);

            if (numbers == 0) {
                return result;
            }

            result[map.get(spell).get(0)] = numbers;
        
            if(map.get(spell).size() == 1) {
                map.remove(spell);
            } else {
                map.get(spell).remove(0);
            }
        }

        return result;
    }
    //success = 16
    //spells = [3,1,2]
    //spells = [1,2,3]
    //positions = [5,8,8]

    private int getValues(int spell, int[] potions, long success) {
        int l = 0;
        int r = potions.length - 1;
        int m = (l + r) / 2;
        int lastValidPosition = potions.length;
        long res = 0l;

        while (l <= r) {
            m = (l + r) / 2;
            res = (long) spell * potions[m];

            if (res >= success) {
                lastValidPosition = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }


        return potions.length - lastValidPosition;
    }

}