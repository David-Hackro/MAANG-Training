class Solution {
    public long dividePlayers(int[] skill) {
        long total = 0;
        Arrays.sort(skill);

        int reference = skill[0] + skill[skill.length - 1];

        for (int i = 0; i < skill.length / 2; i++) {
            int start = skill[i];
            int end = skill[skill.length - 1 - i];

            if ((start + end) != reference) {
                return -1;
            }

            total += (start * end);
        }

        return total;
    }
}