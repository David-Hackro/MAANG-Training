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
        List<Interval> sortedList = new ArrayList<>();

        for (List<Interval> l : schedule) {
            for (Interval interval : l) {
                sortedList.add(interval);
            }
        }

        Collections.sort(sortedList, (a,b) -> Integer.compare(a.start, b.start));
        //[5,21],[45,56],[57,74],[89,96]

        Interval first = sortedList.remove(0); 
        int start = first.start;//5
        int end = first.end;//21
        
    
        while (!sortedList.isEmpty()) {   
            Interval current = sortedList.remove(0);
            //[4,10]
            if(current.start <=  end) { // is inside the range
                end = Math.max(end, current.end);//10
            } else {
                list.add(new Interval(end, current.start));
                start = current.start;
                end = current.end;
            }
        }

        return list;
    }
}