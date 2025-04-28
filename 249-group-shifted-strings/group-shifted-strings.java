class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        int diff = 0;
        StringBuilder sb = new StringBuilder();

        for (String word : strings) {

            char c = word.charAt(0);
            sb = new StringBuilder();

            if (word.length() == 1) {
                sb.append("0" + ",");
            } else {
                sb.append(getDifference(word.charAt(word.length() - 1), word.charAt(0)) + ",");
            }

            for (int i = 1; i < word.length(); i++) {
                diff = getDifference(word.charAt(i - 1), word.charAt(i));
                sb.append(diff + ",");
            }

            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList<String>());
            }

            map.get(sb.toString()).add(word);
        }

        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    private int getDifference(char one, char two) {

        if (one < two) {
            return two - one;
        }

        return ('z' - one) + two - 'a' + 1;
    }
}