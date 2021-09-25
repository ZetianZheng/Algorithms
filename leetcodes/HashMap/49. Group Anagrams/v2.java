public class v2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> ans = new HashMap<>();
        int[] count = new int[26];
        for (String str:strs) {
            Arrays.fill(count, 0); 
            // count identification
            char[] chars = str.toCharArray();
            for (char chr : chars) { // O(char.length)
                int ind = chr - 'a';
                count[ind]++;
            }
            // convert to key
            StringBuilder sb = new StringBuilder();
            for (int c : count) {
                sb.append('#');
                sb.append(c);
            }
            String key = sb.toString();

            if (!ans.containsKey(key))
                ans.put(key, new ArrayList<>());
            ans.get(key).add(str);
        }

        return new ArrayList<>(ans.values());
    }
}
}
