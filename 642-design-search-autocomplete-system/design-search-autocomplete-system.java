class AutocompleteSystem {
    List<String> words;
    StringBuilder sb;
    HashMap<String, Integer> mapByText;

    public AutocompleteSystem(String[] sentences, int[] times) {
        words = new LinkedList<>();
        sb = new StringBuilder();
        mapByText = new HashMap<>();

        for (int i = 0; i < sentences.length; i++) {
            mapByText.put(sentences[i], mapByText.getOrDefault(sentences[i], 0) + times[i]);
        }

        words = getHotSentences();
    }

    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        String prefix;

        if (c == '#') {
            mapByText.put(sb.toString(), mapByText.getOrDefault(sb.toString(), 0) + 1);
            words = getHotSentences();
            sb.setLength(0);
            return result;
        }

        sb.append(c);

        prefix = sb.toString();

        Iterator<String> it = words.iterator();
        int counter = 0;

        while (it.hasNext() && counter < 3) {
            String x = it.next();
            if (x.startsWith(prefix)) {
                result.add(x);
                counter++;
            }
        }

        return result;
    }

    private List<String> getHotSentences() {
        HashMap<Integer, List<String>> mapByFrecuency = new HashMap<>();
        List<Integer> max = new ArrayList<>();
        List<String> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : mapByText.entrySet()) {
            if (!mapByFrecuency.containsKey(entry.getValue())) {
                mapByFrecuency.put(entry.getValue(), new ArrayList<>());
            }

            mapByFrecuency.get(entry.getValue()).add(entry.getKey());
        }

        int[] times = new int[mapByText.size()];
        int index = 0;
        for (int n : mapByText.values()) {
            times[index++] = n;
        }

        Arrays.sort(times);

        for (int i = times.length - 1; i >= 0; i--) {
            max.add(times[i]);
        }

        int counter = 0;

        for (Integer n : max) {

            List<String> results = mapByFrecuency.get(n);// "abc", "abbcfd"

            Collections.sort(results, new Comparator<String>() {
                public int compare(String s1, String s2) {
                    return s1.compareTo(s2);
                }
            });

            list.add(results.get(0));

            mapByFrecuency.get(n).remove(results.get(0));
        }
        return list;

    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
