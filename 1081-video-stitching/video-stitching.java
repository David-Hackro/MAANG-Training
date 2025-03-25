class Solution {
    public int videoStitching(int[][] clips, int time) {
        int pointer = 0;
        int i = 0;
        int counter = 0;

        Arrays.sort(clips, (a, b) -> {
            int lengthA = a[1] - a[0] + 1;
            int lengthB = b[1] - b[0] + 1;
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            if (lengthA == lengthB) {
                return 0;
            }

            return Integer.compare(lengthB, lengthA);
        });

        while (pointer < time && i < clips.length) {
            boolean flag = false;
           
            int max = i;// this is an indice

            while (i < clips.length && clips[i][0] <= pointer) {

                if (clips[i][1] > pointer && clips[i][1] - pointer + 1 >= clips[max][1] - pointer + 1) {
                    max = i;
                    flag = true;
                }

                i++;
            }

            if (flag) {
                counter++;
                pointer = clips[max][1];
            } else {
                i++;
            }
        }

        return pointer >= time?counter:-1;
    }
}