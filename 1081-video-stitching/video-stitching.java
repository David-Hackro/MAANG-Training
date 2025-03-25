class Solution {
    public int videoStitching(int[][] clips, int time) {
        int pointer = 0;
        int i = 0; // indice for the clips array
        int counter = 0;

        Arrays.sort(clips, (a, b) -> {
            int lengthA = a[1] - a[0] + 1;
            int lengthB = b[1] - b[0] + 1;
            // [0,2],[0,6]

            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            // Negative value (less than 0): If x is less than y.
            // Zero (0): If x is equal to y.
            // Positive value (greater than 0): If x is greater than y.

            if (lengthA == lengthB) {
                return 0;
            }

            return Integer.compare(lengthB, lengthA);
        });

        // [[0,4],[0,3],[0,2],[0,1],[1,4],[1,3],[2,6],[2,5],[3,4],[4,7],[4,5],[5,7],[5,6],[6,9],[6,8],[6,7]]

        while (pointer < time && i < clips.length) {
            boolean flag = false;
            // search the first element that the finish value is greather
            // that my current pointer

            int max = i;// this is an indice
            while (i < clips.length) {

                if (clips[i][0] <= pointer) {
                    if (clips[i][1] > pointer) {

                        if (clips[i][1] - pointer + 1 >= clips[max][1] - pointer + 1) {
                            max = i;
                        }
                        flag = true;
                    }
                    i++;
                } else {
                    i++;
                    break;
                }

            }

            if (flag) {
                System.out.println(clips[max][0] + "," + clips[max][1]);
                counter++;
                i--;
                pointer = clips[max][1];
            }
        }

        if (pointer >= time) {
            return counter;
        }

        return -1;
    }
}