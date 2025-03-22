class Solution {
    List<String> result;
    HashSet<String> suppliesSet;
    HashMap<String, List<String>> map;

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        result = new ArrayList<>();
        suppliesSet = new HashSet<>();
        map = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            map.put(recipes[i], ingredients.get(i));
        }

        for (String s : supplies) {
            suppliesSet.add(s);
        }

        while (makeRecipes()) {}


        return result;
    }

    /*
     * Iterator<Integer> it = map.keySet().iterator();
     * while(it.hasNext()) {
     * Integer key = it.next();
     * Object val = map.get(key);
     * if (val.shouldBeRemoved()) {
     * it.remove();
     * }
     * }
     */
    private boolean makeRecipes() {
        boolean flag = false;
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()) {
            String key = it.next();
            List<String> list = map.get(key);
            boolean hasBeenCreated = true;

            for(String ing: list) {
                if(!suppliesSet.contains(ing)) {
                    hasBeenCreated = false;
                    break;
                }
            }

            if(hasBeenCreated) {
                result.add(key);
                suppliesSet.add(key);
                it.remove();
                flag = true;

                return flag;
            }

        }

        return flag;
    }
}
/*
 * "bread,sandwich,burger"
 * 
 * flag = true;
 * size = recipes.size() + 1; //2( tacos)
 * 
 * //while(flag){
 * flag = isPossibleMakeRecipies();//
 * }
 * recipes = ["tacos"]
 * ingredients = [["corn","meat"]]
 * supplies = ["yeast","flour","meat","bread", "sandwich", "burger"]
 */