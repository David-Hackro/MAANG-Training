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

        Interval first = sortedList.remove(0); 
        int start = first.start;
        int end = first.end;
        
    
        while (!sortedList.isEmpty()) {   
            Interval current = sortedList.remove(0);
            if(current.start <=  end) { 
                end = Math.max(end, current.end);
            } else {
                list.add(new Interval(end, current.start));
                start = current.start;
                end = current.end;
            }
        }

        return list;
    }
}