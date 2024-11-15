/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};

*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> list = new ArrayList<>();
        List<Interval> heap = new ArrayList<>();

        /*
         * PriorityQueue<Interval> heap = new PriorityQueue<>((a, b) -> {
         * int r = Integer.compare(a.start, b.start);
         * 
         * if (r != 0) { // when is != 0 are diff
         * return r;
         * }
         * 
         * return Integer.compare(a.end, b.end);
         * }
         * 
         * );
         */

        for (List<Interval> l : schedule) {
            for (Interval interval : l) {
                heap.add(interval);
            }
        }
        Collections.sort(heap, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                int r = Integer.compare(a.start, b.start);

                if (r != 0) { // when is != 0 are diff
                    return r;
                }

                return Integer.compare(a.end, b.end);
            }
        });

        Interval prev; // remove the firt (low) item
        Interval current;
        while (heap.size() > 1) {
            prev = heap.remove(0);// [1,3]
            current = heap.remove(0);// [2,4]

            // if end is greather that start to the next
            if (prev.end > current.start) { // the current element is inside the prev element
                heap.add(0, new Interval(prev.start, Math.max(prev.end, current.end)));
            } else { // we found a common space
                if (prev.end != current.start) {
                    list.add(new Interval(prev.end, current.start));
                }

                heap.add(0, current);
            }
        }

        return list;
    }
}