class Solution {
    HashSet<Integer> seen = new HashSet<>();

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        seen.add(0);
        dfs(0, rooms);
    
        return  seen.size() == rooms.size();
    }

    private void dfs(int i, List<List<Integer>> rooms){
        for(int n: rooms.get(i)) {
            if(!seen.contains(n)) {
                seen.add(n);
                dfs(n, rooms);
            }
        }
    }
}