class RandomizedSet {

    HashSet<Integer> set;
    Random random = new Random();

    public RandomizedSet() {
        set = new HashSet<>();    
    }
    
    public boolean insert(int val) {
        if(set.contains(val)) {
            return false;
        }

        set.add(val);

        return true;
    }
    
    public boolean remove(int val) {
        if(!set.contains(val)) {
            return false;
        }

        set.remove(val);

        return true;
    }
    
    public int getRandom() {
        int index = random.nextInt(set.size());
        ArrayList<Integer> list = new ArrayList<>(set);

        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */