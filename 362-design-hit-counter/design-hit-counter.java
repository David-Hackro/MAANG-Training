class HitCounter {
    List<Integer> list;
    int l;

    public HitCounter() {
        list = new ArrayList<>();
        l = 0;
    }

    public void hit(int timestamp) {
        list.add(timestamp);
    }

    public int getHits(int timestamp) {
        int res = timestamp - 300;
        int r = list.size() - 1;

        if (res <= 0) {
            return list.size();
        }

        //1,2,3,300,301
        while (l <= r) {
            int mid = (l + r) / 2;

            if (list.get(mid) <= res) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return list.size() - l;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */