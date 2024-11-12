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

public class CheckFieldsOneByOne implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int nameCompare = o1.getName().compareTo(o2.getName());
        if(nameCompare != 0) {
            return nameCompare;
        }
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> list = new ArrayList<>();
        // Integer.compare(
        PriorityQueue<Interval> heap = new PriorityQueue<>((a, b) -> {
            int r = Integer.compare(a.start, b.start);

            if (r != 0) { // when is != 0 are diff
                return r;
            }

            return Integer.compare(a.end, b.end);
        }

        );// working

        for (List<Interval> l : schedule) {
            for (Interval interval : l) {
                heap.add(interval);
            }
        }

        // schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
        // [,[9,12]
        // [6,7]
        Interval prev; // remove the firt (low) item
        Interval current;
        while (heap.size() > 1) {
            prev = heap.remove();// [1,3]
            current = heap.remove();// [2,4]

            // if end is greather that start to the next
            if (prev.end > current.start) { // the current element is inside the prev element
                heap.add(new Interval(prev.start, Math.max(prev.end, current.end)));
            } else { // we found a common space
                if(prev.end != current.start) {
                    list.add(new Interval(prev.end, current.start));    
                }
                
                heap.add(current);
            }
        }

        return list;
    }
}