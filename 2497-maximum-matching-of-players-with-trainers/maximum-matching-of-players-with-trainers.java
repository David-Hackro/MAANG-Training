class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int result = 0;
        int i = 0;// player index
        int j = 0;// trainer index
        int player = 0;
        int trainer = 0;
        
        // increase order
        Arrays.sort(players);
        Arrays.sort(trainers);

        while (i < players.length && j <  trainers.length) {

                player = players[i];
                trainer = trainers[j];

                if(player <= trainer) {
                    result++;
                    i++;
                } 

                j++;
        }

        return result;
    }
}