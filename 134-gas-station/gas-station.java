class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int i = 0;
        int index = 0;
        boolean flag;
        //figure out possible gas station
        while (index < gas.length && i < gas.length) {

            if (tank < 0) {
                index = i;
                i = index;
                tank = 0;
                flag = true;
            } else {
                tank += gas[i] - cost[i];
                i++;
            }
        }

        i = 0;
        if (tank >= 0) {
            //validate since start to index
            for (; i < index; i++) {
                if (tank < 0) {
                    return -1;
                } else {
                    tank += gas[i] - cost[i];
                }
            }
        }

        return tank < 0 ? -1 : index;
    }
}