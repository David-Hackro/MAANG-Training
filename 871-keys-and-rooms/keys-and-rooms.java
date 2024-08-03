class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> seen = new HashSet<>();

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        map.put(0, map.get(rooms.get(0)));
        seen.add(0);
        dfs(0, rooms);
    

        return  seen.size() == rooms.size();
    }

    private void dfs(int i, List<List<Integer>> rooms){
        for(int n: rooms.get(i)) {
            if(!map.containsKey(n)) {
                map.put(n, rooms.get(n));
            }

            if(!seen.contains(n)) {
                seen.add(n);
                dfs(n, rooms);
            }
        }
    }
}