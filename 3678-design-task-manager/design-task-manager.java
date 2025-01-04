import java.util.*;

class TaskManager {

    PriorityQueue<int[]> maxHeap;
    HashMap<Integer, int[]> map;
    HashMap<Integer, List<Integer>> removed;

    public TaskManager(List<List<Integer>> tasks) {
        map = new HashMap<>();
        removed = new HashMap<>();
        maxHeap = new PriorityQueue<>(
                (a, b) -> {
                    if (b[2] != a[2]) {
                        return Integer.compare(b[2], a[2]);
                    } else {
                        return Integer.compare(b[1], a[1]);
                    }
                });

        for (List<Integer> innerList : tasks) {
            int[] item = new int[] { innerList.get(0), innerList.get(1), innerList.get(2) };
            maxHeap.add(item);

            map.put(item[1], item);
        }
    }

    public void add(int userId, int taskId, int priority) {
        int[] item = new int[] { userId, taskId, priority };
        maxHeap.add(item);
        map.put(taskId, item);
    }

    public void edit(int taskId, int newPriority) {
        int[] item =  map.get(taskId);
        int[] newItem = new int[] { item[0], taskId, newPriority };
        
        map.put(taskId, newItem);
        maxHeap.remove(item);
        maxHeap.add(newItem);
    }

    public void rmv(int taskId) {
        int[] item =  map.get(taskId);
        
        if (!removed.containsKey(taskId)) {
            removed.put(taskId, new ArrayList<>());
        }

        removed.get(taskId).add(item[0]);
        map.remove(taskId);
    }

    public int execTop() {
        while (!maxHeap.isEmpty()) {
            int[] task = maxHeap.peek();

            if (removed.containsKey(task[1]) && removed.get(task[1]).contains(task[0])) {
                maxHeap.poll(); 
            } else {
                return maxHeap.poll()[0]; 
            }
        }

        return -1;
    }
}
