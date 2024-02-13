class RandomizedSet {
    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random random;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false; 
        }

        map.put(val, list.size());
        list.add(list.size(), val);

        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }

        int getLastValueOfList = list.get(list.size() - 1);
        int indexOfMap = map.get(val);

        map.put(getLastValueOfList, indexOfMap);
        list.set(indexOfMap, getLastValueOfList);

        list.remove(list.size() -1);
        map.remove(val);

        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */